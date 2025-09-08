
# Flyweight — Deduplicate Glyph Styles (Refactoring)

## Solution: Flyweight Pattern for Glyph Rendering

### Problem
The original code stored font, size, and bold style in every `Glyph` object. Rendering long texts created thousands of duplicate style objects, causing high memory usage.

### Solution
We applied the **Flyweight** pattern:

- **Extracted `TextStyle`**: An immutable class holding font, size, and bold. This is the intrinsic (shared) state.
- **Created `TextStyleFactory`**: A factory with a cache (Map) to ensure only one `TextStyle` exists for each unique combination.
- **Refactored `Glyph`**: Now holds only the character (extrinsic state) and a reference to a shared `TextStyle`.
- **Updated `Renderer`**: Uses the factory to get (and share) `TextStyle` objects, then creates `Glyph` objects with them.

### Benefits
- **Memory Efficient**: Identical styles are shared, drastically reducing memory usage for large texts.
- **Immutability**: `TextStyle` is immutable and safe to share.
- **Same Output**: Rendering cost and output remain unchanged.

### How to Check Sharing
You can verify that identical style configs reuse the same `TextStyle` instance by comparing references (==) in code.

---

## How to Build & Run
```bash
cd flyweight-glyphs/src
javac com/example/render/*.java
java com.example.render.App
```

---

## Summary of Changes
- Added `TextStyle.java` (immutable style class)
- Added `TextStyleFactory.java` (caching factory)
- Refactored `Glyph.java` to use `TextStyle`
- Refactored `Renderer.java` to use the factory and share styles
