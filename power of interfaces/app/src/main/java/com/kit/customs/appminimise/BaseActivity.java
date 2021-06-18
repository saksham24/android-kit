package com.kit.customs.appminimise;

import android.os.Bundle;
import com.kit.customs.appminimise.VisibilityController.ForegroundClients;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Use this class base base class for all activities
 */
public abstract class BaseActivity extends AppCompatActivity implements ForegroundClients {

    @Override
    protected void onStart() {
        super.onStart();
        onActivityVisible();
    }

    @Override
    protected void onStop() {
        super.onStop();
        onActivityInvisible();
    }

    @Override
    public final void onActivityInvisible() {
        GithubApplication.getVisibilityController().removeClients(this);
    }

    @Override
    public final void onActivityVisible() {
        GithubApplication.getVisibilityController().addClient(this);
    }
}