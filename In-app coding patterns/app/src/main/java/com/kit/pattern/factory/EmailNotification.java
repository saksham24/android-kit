package com.kit.pattern.factory;

import android.util.Log;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        Log.i(this.getClass().getSimpleName(), "Email notification");
    }
}