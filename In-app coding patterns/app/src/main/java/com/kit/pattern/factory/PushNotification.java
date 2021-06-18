package com.kit.pattern.factory;

import android.util.Log;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        Log.i(this.getClass().getSimpleName(), "Push notification");
    }
}
