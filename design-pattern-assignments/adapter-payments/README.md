# Adapter — Payments (Refactoring)

## Narrative (Current Code)
OrderService directly depends on two mismatched SDKs (`FastPayClient`, `SafeCashClient`), uses a string `provider` switch, and duplicates glue logic.

## Your Task
Introduce an **Adapter** so `OrderService` depends only on a `PaymentGateway` interface. Create:
- `PaymentGateway` (target interface): `String charge(String customerId, int amountCents)`
- `FastPayAdapter` and `SafeCashAdapter` mapping to their respective SDKs
- A simple map-based registry in `App` to select the gateway

Refactor `OrderService` to accept a `PaymentGateway` and remove provider branching.

## Acceptance Criteria
- `OrderService` calls **only** `PaymentGateway`
- Adding a new provider requires no change to `OrderService`
- Running `App` prints transaction IDs for both providers

## Hints
- Use constructor injection or a `Map<String, PaymentGateway>`
- Keep adapters stateless
- Use `Objects.requireNonNull` to validate inputs

## Build & Run

## Solution & Explanation

### Problem
Originally, `OrderService` depended directly on two different payment SDKs (`FastPayClient` and `SafeCashClient`), each with its own API. This led to code duplication and a switch statement to select the provider, making the code hard to extend and maintain.

### Adapter Pattern Solution
We introduced the Adapter Pattern to decouple `OrderService` from the concrete SDKs:

- **PaymentGateway**: A common interface with `String charge(String customerId, int amountCents)`.
- **FastPayAdapter**: Implements `PaymentGateway`, internally calls `FastPayClient.payNow()`.
- **SafeCashAdapter**: Implements `PaymentGateway`, internally uses `SafeCashClient.createPayment()` and `SafeCashPayment.confirm()`.
- **OrderService**: Now depends only on the `PaymentGateway` interface. It receives a map of provider names to adapters, removing the need for any switch or branching logic.
- **App.java**: Registers adapters for each provider in the map, so adding a new provider only requires a new adapter and map entry.

### Benefits
- `OrderService` is now open for extension (new payment providers) but closed for modification (no changes needed for new providers).
- All SDK-specific logic is isolated in adapters.
- The code is easier to test and maintain.

### How to Run
Compile and run as described below. You should see transaction IDs for both providers printed, demonstrating the adapters in action.
```bash
cd adapter-payments/src
javac com/example/payments/*.java
java com.example.payments.App
```
