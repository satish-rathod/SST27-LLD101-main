# Exercise ex03

How to run:
```bash
cd src
javac Demo03.java.java
java Demo03
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution:

Identified Violations:

The original ShippingCostCalculator used if/else to handle different shipping types, violating the Single Responsibility, Open/Closed, and Dependency Inversion Principles.
Refactored Design:

Introduced a ShippingCostStrategy interface.
Created separate classes: StandardShipping, ExpressShipping, and OvernightShipping, each implementing the strategy interface.
ShippingCostCalculator now depends on the ShippingCostStrategy interface, not concrete types.
Demo Updated:

In Demo03.java, we create different calculators for each shipping type and print their costs.
Result:

The code is now easy to extend (add new shipping types without modifying existing code).
Each class has a single responsibility.
High-level modules depend on abstractions, not concrete implementations.