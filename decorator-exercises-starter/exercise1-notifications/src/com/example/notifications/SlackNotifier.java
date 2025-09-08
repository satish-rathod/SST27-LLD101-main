package com.example.notifications;

public class SlackNotifier implements Notifier {
    private final Notifier wrappee;

    public SlackNotifier(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
        System.out.println("Sending Slack message: " + message);
    }
}
