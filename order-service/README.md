# Order Service

This service will act as the Saga orchestrator.

It will create an order, call `payment-service`, and execute compensation when
the payment step fails.
