package com.kit.pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.kit.R;
import com.kit.pattern.builder.Address;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //user builder pattern instance of Address class
        new Address.Builder()
                .setId(1)
                .setPinCode(110088)
                .setLatitude(12f)
                .setLongitude(14f)
                .setStreet("New Street")
                .setCity("Delhi")
                .setCountry("India")
                .build();
    }
}