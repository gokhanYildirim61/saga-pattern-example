package com.training.saga.order.saga;

import com.training.saga.order.api.dto.CreateCustomerOrderRequest;
import com.training.saga.order.api.dto.CustomerOrderResponse;
import com.training.saga.order.business.CustomerOrderService;
import com.training.saga.order.clients.CustomerClient;
import com.training.saga.order.clients.InventoryClient;
import com.training.saga.order.clients.NotificationClient;
import com.training.saga.order.clients.PaymentClient;
import com.training.saga.order.clients.dto.CustomerClientResponse;
import com.training.saga.order.clients.dto.NotificationClientRequest;
import com.training.saga.order.clients.dto.PaymentClientRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderSagaOrchestrator {

    private final CustomerOrderService customerOrderService;
    private final CustomerClient customerClient;
    private final InventoryClient inventoryClient;
    private final PaymentClient paymentClient;
    private final NotificationClient notificationClient;

    public OrderSagaOrchestrator(CustomerOrderService customerOrderService,
                                 CustomerClient customerClient,
                                 InventoryClient inventoryClient,
                                 PaymentClient paymentClient,
                                 NotificationClient notificationClient) {
        this.customerOrderService = customerOrderService;
        this.customerClient = customerClient;
        this.inventoryClient = inventoryClient;
        this.paymentClient = paymentClient;
        this.notificationClient = notificationClient;
    }

    public CustomerOrderResponse start(CreateCustomerOrderRequest request) {
        CustomerOrderResponse order = customerOrderService.createOrder(request);

        boolean inventoryChanged = false;

        try {
            validateCustomer(request);

            inventoryClient.reserveItem(order.getInventoryItemId());
            inventoryChanged = true;
            order = customerOrderService.markInventoryReserved(order.getId());

            inventoryClient.sellItem(order.getInventoryItemId());

            order = customerOrderService.markPaymentPending(order.getId());
            paymentClient.pay(new PaymentClientRequest(
                    order.getId(),
                    order.getTotalAmount(),
                    request.getPaymentMethod()
            ));

            sendPaymentSuccessNotification(order);

            return customerOrderService.confirmOrder(order.getId());
        } catch (Exception exception) {
            compensate(order, inventoryChanged);

            return customerOrderService.cancelOrder(order.getId());
        }
    }

    private void validateCustomer(CreateCustomerOrderRequest request) {
        CustomerClientResponse customer = customerClient.getCustomerById(request.getCustomerId());

        if (customer == null || !Boolean.TRUE.equals(customer.active())) {
            throw new IllegalStateException("Customer is not active");
        }
    }

    private void compensate(CustomerOrderResponse order, boolean inventoryChanged) {
        if (!inventoryChanged) {
            return;
        }

        try {
            inventoryClient.releaseItem(order.getInventoryItemId());
        } catch (Exception ignored) {
            // Compensation failure would be persisted/logged in a production saga.
        }
    }

    private void sendPaymentSuccessNotification(CustomerOrderResponse order) {
        try {
            notificationClient.sendNotification(new NotificationClientRequest(
                    order.getId(),
                    order.getCustomerId(),
                    "ORDER_PAYMENT_SUCCESS",
                    "Order payment completed successfully"
            ));
        } catch (Exception ignored) {
            // Notification is a non-critical side effect in this training saga.
        }
    }
}
