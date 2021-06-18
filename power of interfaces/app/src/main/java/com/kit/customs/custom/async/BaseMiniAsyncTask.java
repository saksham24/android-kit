package com.kit.customs.custom.async;

import android.os.Handler;
import android.os.Looper;

public abstract class BaseMiniAsyncTask<PARAMS, RESULT> {
    public abstract void onPreExecute();
    public abstract RESULT doInBackground(PARAMS params);
    public abstract void onPostExecute(RESULT result);

    protected PARAMS params;
    private RESULT result;

    public final void execute() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                onPreExecute();
                callInBackground();
            }
        });
    }

    public final RESULT get() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("Can't call get() method on Main thread.");
        }
        return doInBackground(params);
    }

    public final void callInBackground() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                RESULT result = doInBackground(params);
                callPostExecute(result);
            }
        }.start();
    }

    public final void callPostExecute(RESULT result) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                onPostExecute(result);
            }
        });
    }


}
