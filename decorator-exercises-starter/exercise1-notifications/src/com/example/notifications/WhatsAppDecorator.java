package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String waUser;

    public WhatsAppDecorator(Notifier wrappee, String waUser) {
        super(wrappee);
        this.waUser = waUser;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[WHATSAPP -> " + waUser + "]: " + text);
    }
}
