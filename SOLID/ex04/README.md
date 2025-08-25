# Exercise ex04

How to run:
```bash
cd src
javac Demo04.java.java
java Demo04
```


Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

---

## Steps to resolve the SOLID violation

1. **Identify the Violation:**
	- The original `PaymentService` used a `switch` on a string provider, violating the Open/Closed Principle (OCP). Adding new payment types required modifying existing code.
	- Multiple responsibilities were mixed, violating the Single Responsibility Principle (SRP).

2. **Refactor for SOLID Compliance:**
	- Define a `PaymentProvider` interface with a `pay(double amount)` method.
	- Implement concrete classes: `CardPayment`, `UpiPayment`, and `WalletPayment`, each handling its own payment logic.
	- Refactor `PaymentService` to depend on the `PaymentProvider` abstraction, not on concrete types or a switch.
	- Move each class/interface to its own file as per Java conventions.

3. **Demo/Test:**
	- Update `Demo04.java` to show usage of all payment providers via the new interface.
	- Compile and run to verify output and behavior remain correct.
