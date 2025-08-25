# Exercise ex05

How to run:
```bash
cd src
javac Demo05.java.java
java Demo05
```


Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

---

## Steps to Resolve

1. **Identify the Violation:**
	- The code violates the Liskov Substitution Principle (LSP). `Square` inherits from `Rectangle`, but a `Square` cannot substitute a `Rectangle` without breaking expected behavior (setting width/height independently).

2. **Refactor:**
	- Remove the inheritance (`Square` should not extend `Rectangle`).
	- Optionally, create a `Shape` interface with an `area()` method, and let both `Rectangle` and `Square` implement it.
	- Update both classes to work independently.

3. **Update Demo/Test:**
	- In `Demo05.java`, create and use both `Rectangle` and `Square` objects.
	- Print their areas to verify correct behavior.

4. **How to Run:**
	- From the `src` directory, compile and run:
	  ```bash
	  javac Demo05.java
	  java Demo05
	  ```
