package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
    Notifier base = new EmailNotifier("user@example.com");
    System.out.println("--- Baseline: Email only ---");
    base.notify("Baseline email only.");

    System.out.println("\n--- Email + SMS ---");
    Notifier emailSms = new SmsDecorator(base, "+91-99999-11111");
    emailSms.notify("Build green ✅");

    System.out.println("\n--- Email + WhatsApp ---");
    Notifier emailWa = new WhatsAppDecorator(base, "user_wa");
    emailWa.notify("Release ready!");

    System.out.println("\n--- Email + Slack ---");
    Notifier emailSlack = new SlackDecorator(base, "deployments");
    emailSlack.notify("Deployment started");

    System.out.println("\n--- Email + WhatsApp + Slack ---");
    Notifier full = new SlackDecorator(new WhatsAppDecorator(base, "user_wa"), "deployments");
    full.notify("Deployment completed 🚀");
    }
}
