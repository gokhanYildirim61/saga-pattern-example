# Payment Service

This service owns payment reservation and payment compensation.

It must not know the whole order workflow. It only responds to commands from
the Saga orchestrator.
