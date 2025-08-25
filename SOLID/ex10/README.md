# Exercise ex10

How to run:
```bash
cd src
javac Demo10.java.java
java Demo10
```


Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

---

## Steps to resolve

1. **Identify SOLID Violations**
	- `ReportService` directly depends on `ConsoleLogger` (a concrete class), violating the Dependency Inversion Principle (DIP) and Open/Closed Principle (OCP).
	- To add new logger types, `ReportService` would need to be modified, which is not OCP-compliant.

2. **Refactor for SOLID Compliance**
	- Introduce a `Logger` interface with a `log(String msg)` method.
	- Make `ConsoleLogger` implement the `Logger` interface.
	- Change `ReportService` to depend on the `Logger` interface (constructor injection).
	- Update `Demo10` to inject a `Logger` instance into `ReportService`.

3. **Demo/Test**
	- In `Demo10`, demonstrate usage with both `ConsoleLogger` and a test logger (e.g., an anonymous class).
	- Ensure output shows both loggers working as expected.

---
