package com.example.mobsoft.f1gpcalendar;


import android.app.Application;

import com.example.mobsoft.f1gpcalendar.ui.UIModule;

public class F1GPCalendarApplication extends Application {

    public static F1GPCalendarApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerF1GPCalendarApplicationComponent.builder().
                uIModule(
                        new UIModule(this)
                ).build();
    }
}
