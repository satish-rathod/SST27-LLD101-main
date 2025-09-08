# Exercise 1: Notifications Decorator Pattern

## Problem
You are given a notification system with a base `Notifier` interface and an `EmailNotifier` implementation. The task is to extend the system so that it can support additional notification channels (like SMS, Slack, etc.) using the Decorator design pattern, without modifying the existing code.

## Solution
I implemented the Decorator pattern by creating new decorator classes that wrap a `Notifier` and add extra notification behavior. Each decorator takes a `Notifier` as a constructor argument and delegates the notification call, adding its own logic before or after the call. This allows dynamic composition of notification channels.

## Steps
1. Created a `Notifier` interface and an `EmailNotifier` class (already provided).
2. Implemented new decorator classes (e.g., `SMSNotifier`, `SlackNotifier`) that implement `Notifier` and wrap another `Notifier`.
3. In the client code, composed multiple decorators to send notifications through multiple channels.
4. Verified that adding new channels does not require changes to existing code, only new decorators.

---

**Example usage:**
```java
Notifier notifier = new SlackNotifier(new SMSNotifier(new EmailNotifier()));
notifier.send("Hello!");
```
This sends the notification via Email, then SMS, then Slack.
