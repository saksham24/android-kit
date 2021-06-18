package com.kit.customs.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MiniLiveData<GENERIC> {
    public interface Observer<GENERIC>{
        void onChanged(GENERIC object);
    }

    private GENERIC value;
    private List<Observer<GENERIC>> observers = new ArrayList<>();

    public MiniLiveData() {}

    public MiniLiveData(GENERIC value) {
        this.value = value;
    }

    public void setValue(GENERIC value) {
        this.value = value;
        for (Observer<GENERIC> observer : observers) {
            observer.onChanged(value);
        }
    }

    public void postValue(GENERIC value) {
        this.value = value;
        for (Observer<GENERIC> observer : observers) {
            observer.onChanged(value);
        }
    }

    public void observe(Observer<GENERIC> observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer<GENERIC> observer) {
        observers.remove(observer);
    }
}
