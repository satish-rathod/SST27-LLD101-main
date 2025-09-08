# Adapter — CSV Import (Feature Implementation)

## Narrative (Current Code)
You must add a CSV import feature. The only available utility is a low-level `NaiveCsvReader` that returns `List<String[]>`. The domain service `ProfileService` expects validated fields.

## Your Task
Implement `CsvProfileImporter` that adapts `NaiveCsvReader` to the `ProfileImporter` interface:
- Parse: columns `id,email,displayName`
- Validate: skip invalid rows (missing id/email or bad email)
- Count successful imports

Wire `App` to accept a CSV path and print a summary.

## Acceptance Criteria
- `java com.example.imports.App users.csv` prints created profiles and `Imported N profiles`
- Invalid rows are skipped with an explanatory message
- `ProfileService` remains unchanged

## Hints
- Use `Objects.requireNonNull`
- Do validation in the adapter; keep the domain service clean

## Build & Run
```bash
cd adapter-csv-import/src
javac com/example/imports/*.java
java com.example.imports.App users.csv
```


# Solution Steps & Explanation

## Design Pattern Used
This problem is solved using the **Adapter Design Pattern**. The goal is to allow the `ProfileImporter` interface to work with the existing `NaiveCsvReader` utility, which has a different method signature and output format.

## Steps Taken
1. **Created `CsvProfileImporter` Adapter:**
	- Implements the `ProfileImporter` interface.
	- Internally uses `NaiveCsvReader` to read the CSV file.
	- Adapts the output to the needs of the domain (`ProfileService`).
2. **Validation in Adapter:**
	- Each row is checked for required fields (`id`, `email`).
	- Skips rows with missing or invalid data, printing an explanatory message.
	- Only valid rows are passed to `ProfileService.createProfile`.
3. **Wired in `App.java`:**
	- The main method now creates a `CsvProfileImporter` and calls `importFrom` with the CSV path.
	- Prints the number of successfully imported profiles.

## How the Adapter Works
- The adapter (`CsvProfileImporter`) takes a `NaiveCsvReader` and a `ProfileService`.
- It reads all rows from the CSV file, validates each row, and calls the domain service for valid data.
- Invalid rows are skipped with a message, as required.
- The adapter counts and returns the number of successful imports.

## Why Adapter Pattern?
The Adapter Pattern is ideal here because:
- The existing utility (`NaiveCsvReader`) cannot be changed.
- The domain expects a different interface (`ProfileImporter`).
- The adapter bridges the gap, allowing seamless integration without modifying existing code.

---
**This solution keeps the domain service clean and focused, while handling all adaptation and validation logic in the adapter.**
