# Exercise ex08

How to run:
```bash
cd src
javac Demo08.java.java
java Demo08
```


Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

---

## SOLID Violations

- **Liskov Substitution Principle (LSP) Violation:**  
	`Bicycle` implements `Vehicle`, but methods like `startEngine()` and `recharge()` do not make sense for a bicycle. Calling these methods throws `UnsupportedOperationException`, breaking substitutability.

- **Interface Segregation Principle (ISP) Violation:**  
	The `Vehicle` interface forces all vehicles to implement methods that are not relevant to all types (e.g., not all vehicles have engines or need recharging).

---

## Steps to Resolve

1. **Split the `Vehicle` interface** into smaller, more specific interfaces:
	 - `EnginePowered` (with `startEngine()`)
	 - `Pedalable` (with `pedal(int effort)`)
	 - `Rechargeable` (with `recharge(int kWh)`)

2. **Update `Bicycle`** to only implement `Pedalable`.

3. **Update the demo** to use the new interfaces and show correct usage.

4. **Test** to ensure the new design works and no longer throws exceptions for unsupported operations.
