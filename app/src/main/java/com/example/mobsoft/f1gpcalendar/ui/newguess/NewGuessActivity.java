package com.example.mobsoft.f1gpcalendar.ui.newguess;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.example.mobsoft.f1gpcalendar.R;

import io.fabric.sdk.android.Fabric;

public class NewGuessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_new_guess);
    }
}
