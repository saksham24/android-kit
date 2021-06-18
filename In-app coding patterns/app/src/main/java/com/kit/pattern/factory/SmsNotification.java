package com.kit.pattern.factory;

import android.util.Log;

public class SmsNotification implements Notification{
    @Override
    public void notifyUser() {
        Log.i(this.getClass().getSimpleName(), "SMS notification");
    }
}
