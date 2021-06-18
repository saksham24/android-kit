package com.kit.customs.appminimise;

import java.util.ArrayList;

public class VisibilityController {
    public interface ForegroundClients {
        void onActivityInvisible();
        void onActivityVisible();
    }

    public interface VisibilityCallbacks {
        void onAppVisible();
        void onAppMinimised();
    }

    private static volatile VisibilityController sVisibilityController;
    private ArrayList<ForegroundClients> mClients;
    private VisibilityCallbacks visibilityCallbacks;
    private boolean isForegroundState;

    public static VisibilityController getInstance(VisibilityCallbacks visibilityCallbacks) {
        synchronized (VisibilityController.class) {
            if (sVisibilityController == null) {
                sVisibilityController = new VisibilityController(visibilityCallbacks);
            }
        }

        return sVisibilityController;
    }

    private VisibilityController(VisibilityCallbacks visibilityCallbacks) {
        mClients = new ArrayList<>();
        this.visibilityCallbacks = visibilityCallbacks;
    }

    public void addClient(ForegroundClients foregroundClients) {
        if (!mClients.contains(foregroundClients)) {
            mClients.add(foregroundClients);
            resolveVisibility();
        }
    }

    public void removeClients(ForegroundClients foregroundClients) {
        if (mClients.contains(foregroundClients)) {
            mClients.remove(foregroundClients);
            resolveVisibility();
        }
    }

    public void resolveVisibility() {
        if (isForegroundState && mClients.size() == 0) {
            isForegroundState = false;
            visibilityCallbacks.onAppMinimised();
        } else if (!isForegroundState && mClients.size()>0){
            isForegroundState = true;
            visibilityCallbacks.onAppVisible();
        }
    }
}
