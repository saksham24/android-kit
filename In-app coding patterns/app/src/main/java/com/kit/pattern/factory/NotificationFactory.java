package com.kit.pattern.factory;

public class NotificationFactory {
    public Notification createNotification(String channel) {
        if (channel.equals("SMS")) {
            return new SmsNotification();
        } else if (channel.equals("EMAIL")) {
            return new EmailNotification();
        } else if (channel.equals("PUSH")) {
            return new PushNotification();
        }

        return null;
    }
}
