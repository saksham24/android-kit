package com.kit.pattern.command;

import android.util.Log;

public class Light {
    public void on() {
        Log.i(this.getClass().getSimpleName(), "Light on");
    }

    public void off() {
        Log.i(this.getClass().getSimpleName(), "Light off");
    }
}
