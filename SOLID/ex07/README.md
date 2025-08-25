# Exercise ex07

How to run:
```bash
cd src
javac Demo07.java.java
java Demo07
```


Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

---

## SOLID Violation(s) Identified
- **Interface Segregation Principle (ISP):** The `Machine` interface/class forces all implementers (like `BasicPrinter`) to implement methods they do not need (e.g., scan, fax), violating ISP.
- **Single Responsibility Principle (SRP):** The `Machine` interface/class may also violate SRP by grouping unrelated functionalities together.

## Steps to Resolve
1. Analyze the current `Machine` interface/class and its implementations.
2. Identify methods that are not relevant for all implementers (e.g., scan, fax).
3. Create smaller, more specific interfaces:
	- `Printer` with `print(Document d)`
	- `Scanner` with `scan(Document d)`
	- (Add more as needed)
4. Update `BasicPrinter` to implement only the relevant interface(s).
5. Update `Demo07.java` to use the new interfaces and show a working example.
6. Test the code to ensure behavior is preserved.

---

**Refactor summary:**
- Split the `Machine` interface/class into smaller interfaces.
- Make each class implement only what it needs.
- Update the demo to show correct usage.
