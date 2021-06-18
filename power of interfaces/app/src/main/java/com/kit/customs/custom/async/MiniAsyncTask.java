package com.kit.customs.custom.async;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class MiniAsyncTask extends BaseMiniAsyncTask<Integer, String> {

    public MiniAsyncTask(Integer params) {
        this.params = params;
    }

    @Override
    public void onPreExecute() {
        Log.i(this.getClass().getSimpleName(), ": in pre-execute");
    }

    @Override
    public String doInBackground(Integer params) {
        Log.i(this.getClass().getSimpleName(), ": in do in background");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "some data";
    }

    @Override
    public void onPostExecute(String result) {
        Log.i(this.getClass().getSimpleName(), ": in post-execute");
    }
}
