package com.kit.pattern.command;

import android.util.Log;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        Log.i(this.getClass().getSimpleName(), "in light off command method");
        light.off();
    }
}
