package com.kit.pattern.command;

import android.util.Log;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        Log.i(this.getClass().getSimpleName(), "in light on command method");
        light.on();
    }
}
