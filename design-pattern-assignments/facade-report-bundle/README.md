
# Facade — Report Bundle Export (Solution)

## Facade Pattern Explanation
The Facade pattern provides a unified interface to a set of interfaces in a subsystem. In this exercise, the `ReportBundleFacade` class acts as the Facade, hiding the complexity of report export (writing JSON, zipping, and logging) behind a single method.

## Solution Overview
- **`ReportBundleFacade`**: Offers a static `export` method that:
	1. Writes the report data as JSON using `JsonWriter`.
	2. Zips the JSON file using `Zipper`.
	3. Logs the export operation using `AuditLog`.
- **`App`**: Uses only the Facade, not the individual utility classes.

## Benefits
- The main application code is much simpler and less error-prone.
- The order and details of subsystem interactions are hidden from the caller.
- Any IO errors are surfaced as `UncheckedIOException`.

## How to Run
```bash
cd facade-report-bundle/src
javac com/example/report/*.java
java com.example.report.App
```
On success, you will see the path to the `.zip` file printed and an entry written to `audit.log`.

## Changes Made
- Implemented `ReportBundleFacade` as a Facade to orchestrate report export.
- Refactored `App` to use only the Facade.
- Kept utility classes (`JsonWriter`, `Zipper`, `AuditLog`) unchanged.

---
**This solution demonstrates the Facade pattern by providing a simple interface for a complex subsystem, improving code maintainability and usability.**
