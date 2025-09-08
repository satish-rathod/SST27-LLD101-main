# Exercise 2: Game Character Decorator Pattern

## Problem
You are given a game character system with a `Character` interface and a `BaseCharacter` implementation. The task is to add new abilities (like shields, power-ups, etc.) to characters at runtime using the Decorator design pattern, without modifying the existing code.

## Solution
I used the Decorator pattern to add new abilities to characters. Each ability is implemented as a decorator class that wraps a `Character` and adds or modifies behavior (such as increasing health, adding shields, etc.). This allows flexible and dynamic composition of character abilities.

## Steps
1. Used the provided `Character` interface and `BaseCharacter` class.
2. Created new decorator classes (e.g., `ShieldDecorator`, `PowerUpDecorator`) that implement `Character` and wrap another `Character`.
3. In the game logic, wrapped characters with decorators to add abilities as needed.
4. Verified that new abilities can be added without changing existing code, just by creating new decorators.

---

**Example usage:**
```java
Character hero = new ShieldDecorator(new PowerUpDecorator(new BaseCharacter("Hero")));
hero.attack();
```
This creates a character with both shield and power-up abilities.
