# Exercise ex06

How to run:
```bash
cd src
javac Demo06.java.java
java Demo06
```


Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

---

## SOLID Violation(s) Identified

- **Liskov Substitution Principle (LSP):** `Penguin` extends `Bird` but cannot fly, while `Bird` has a `fly()` method. Substituting a `Penguin` for a `Bird` breaks code expecting all `Bird`s to fly.
- **Interface Segregation Principle (ISP):** `Bird` may have methods not applicable to all birds (e.g., `fly()` for non-flying birds).

## Steps to Resolve

1. Identified that `Penguin` cannot fly, but `Bird` defines a `fly()` method, violating LSP.
2. Created a `Flyable` interface with a `fly()` method.
3. Made only those birds that can fly implement `Flyable`.
4. Removed `fly()` from `Bird` base class.
5. Updated demo code to show both flying and non-flying birds.
6. Verified behavior with a simple test in `Demo06.java`.
