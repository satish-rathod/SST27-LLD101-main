# Exercise ex09

How to run:
```bash
cd src
javac Demo09.java.java
java Demo09
```


Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

---

## Steps to resolve SOLID violations

1. **Identify Violations:**
	- Review the code in `OrderController.java` and `SqlOrderRepository.java` for SOLID principle violations (e.g., tight coupling, multiple responsibilities, etc.).

2. **Refactor for SOLID Compliance:**
	- **Single Responsibility Principle (SRP):** Ensure each class has only one reason to change. If `OrderController` is handling both business logic and data access, extract repository logic into an interface.
	- **Open/Closed Principle (OCP):** Classes should be open for extension but closed for modification. Use interfaces or abstract classes for repositories.
	- **Liskov Substitution Principle (LSP):** Ensure subclasses or implementations can replace their parent/interface without breaking functionality.
	- **Interface Segregation Principle (ISP):** Use small, specific interfaces rather than large, general-purpose ones.
	- **Dependency Inversion Principle (DIP):** Depend on abstractions, not concrete classes. Inject repository dependencies into controllers via interfaces.

3. **Refactor Code:**
	- Create an `OrderRepository` interface.
	- Make `SqlOrderRepository` implement `OrderRepository`.
	- Update `OrderController` to depend on `OrderRepository` (constructor injection).
	- Update `Demo09.java` to use the new structure and demonstrate the behavior.

4. **Test:**
	- Add a simple test/demo in `Demo09.java` to show the refactored code works as expected.

---
