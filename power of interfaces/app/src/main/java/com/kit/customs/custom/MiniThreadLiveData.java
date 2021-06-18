package com.kit.customs.custom;

import android.os.Handler;
import android.os.Looper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MiniThreadLiveData<GENERIC> {
    public interface Observer<GENERIC> {
        void onChanged(GENERIC object);
    }

    private GENERIC value;
    private final Map<Observer<GENERIC>, Boolean> observerSet = new HashMap<>();

    public MiniThreadLiveData() {}

    public MiniThreadLiveData(GENERIC value) {
        this.value = value;
    }

    public void setValue(GENERIC value) {
        this.value = value;

        for (Map.Entry<Observer<GENERIC>, Boolean> observerUnit : observerSet.entrySet()) {
            Observer<GENERIC> observer = observerUnit.getKey();
            if ((Boolean) observerUnit.getValue()) {
                callObserverOnUi(observer, value);
            } else {
                observer.onChanged(value);
            }
        }
    }

    private void callObserverOnUi(Observer<GENERIC> observer, GENERIC value) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                observer.onChanged(value);
            }
        });
    }

    public void postValue(GENERIC value) {
        this.value = value;
        for (Map.Entry<Observer<GENERIC>, Boolean> observerUnit : observerSet.entrySet()) {
            Observer<GENERIC> observer = observerUnit.getKey();
            if ((Boolean) observerUnit.getValue()) {
                callObserverOnUi(observer, value);
            } else {
                observer.onChanged(value);
            }
        }
    }

    public void observe(Observer<GENERIC> observer) {
        this.observerSet.put(observer, false);
    }

    public void observeOnUi(Observer<GENERIC> observer) {
        this.observerSet.put(observer, true);
    }

    public void removeObserver(Observer<GENERIC> observer) {
        observerSet.remove(observer);
    }
}
