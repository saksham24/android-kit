package com.kit.customs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.android.kit.R;
import com.kit.customs.appminimise.BaseActivity;
import com.kit.customs.custom.MiniLiveData;
import com.kit.customs.custom.MiniThreadLiveData;
import com.kit.customs.custom.async.MiniAsyncTask;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Works the same as live-data class of android. Remember to unregister the observer when activity is destroyed
         * as we have not integrated activity life cycle callbacks.
         * This is simple Java-interfaces and generic's implementation to give raw idea that how these well known classes are made by android.
         * Note: This observer will give callback on the same thread on which it's value is changed.
         */
        new MiniLiveData<>("hello").observe(new MiniLiveData.Observer<String>() {
            @Override
            public void onChanged(String value) {
                Log.i(this.getClass().getSimpleName(), "Live data value changed " + value);
            }
        });


        /*
         * Works the same as live-data class of android. Remember to unregister the observer when activity is destroyed
         * as we have not integrated activity life cycle callbacks.
         * This is simple Java-interfaces and generic's implementation to give raw idea that how these well known classes are made by android.
         * Note: This observer will give callback on the UI thread even if we change it's value on back thread.
         */
        new MiniThreadLiveData<>("hello").observeOnUi(new MiniThreadLiveData.Observer<String>() {
            @Override
            public void onChanged(String value) {
                Log.i(this.getClass().getSimpleName(), "Live data value changed " + value);
            }
        });


        /*
         * Works same as AsyncTask class of android.
         * This is simple Java-interfaces and generic's implementation to give raw idea that how these well known classes are made by android.
         */
        new MiniAsyncTask(2).execute();
    }
}