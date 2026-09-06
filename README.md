# Saga Pattern Example

This module demonstrates an orchestration-based Saga with two independent
Spring Boot microservices.

## Services

| Service | Responsibility | Port |
| --- | --- | --- |
| `common` | Shared technical classes | - |
| `order-service` | Starts and coordinates the order workflow | `8080` |
| `customer-information-management` | Provides customer information | `8082` |
| `inventory-service` | Reserves, sells, and releases products | `8083` |
| `payment-service` | Reserves and compensates payment | `8081` |

## Planned workflow

```text
Create order
    -> reserve payment
    -> order confirmed

If payment fails:
    -> cancel order
```

The orchestrator owns the workflow. Each service owns its own data and exposes
an action plus a compensating action. There is no shared domain package.

## Learning order

1. Create the two Spring Boot main classes.
2. Add the order and payment request/response models.
3. Implement the payment reserve endpoint.
4. Implement the payment compensation endpoint.
5. Implement the order orchestrator.
6. Test both success and payment-failure scenarios.
