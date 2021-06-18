package com.kit.pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.kit.R;
import com.kit.pattern.builder.Address;
import com.kit.pattern.command.Command;
import com.kit.pattern.command.Light;
import com.kit.pattern.command.LightOffCommand;
import com.kit.pattern.command.LightOnCommand;
import com.kit.pattern.factory.Notification;
import com.kit.pattern.factory.NotificationFactory;

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

        //user factory pattern instance
        Notification notificationSms = new NotificationFactory().createNotification("SMS");
        notificationSms.notifyUser();

        Notification notificationEmail = new NotificationFactory().createNotification("EMAIL");
        notificationEmail.notifyUser();

        //command pattern usage
        Command commandOn = new LightOnCommand(new Light());
        commandOn.execute();

        Command commandOff = new LightOffCommand(new Light());
        commandOff.execute();


    }
}