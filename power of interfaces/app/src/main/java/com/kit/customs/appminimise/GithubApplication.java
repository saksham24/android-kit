package com.kit.customs.appminimise;

import android.app.Application;
import android.util.Log;

import com.kit.customs.appminimise.VisibilityController.VisibilityCallbacks;

public class GithubApplication extends Application implements VisibilityCallbacks {
    private static VisibilityController sVisibilityController;

    @Override
    public void onCreate() {
        super.onCreate();
        sVisibilityController = VisibilityController.getInstance(this);
    }

    @Override
    public void onAppVisible() {
        Log.i(this.getClass().getSimpleName(), "Application is now visible");
        // Fire Event bus, broadcasts  or any event you want
    }

    @Override
    public void onAppMinimised() {
        Log.i(this.getClass().getSimpleName(), "Application is now minimised");
        // Fire Event bus, broadcasts  or any event you want
    }

    public static VisibilityController getVisibilityController() {
        return sVisibilityController;
    }
}
