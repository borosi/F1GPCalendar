package com.example.mobsoft.f1gpcalendar;


import android.app.Application;

public class F1GPCalendarApplication extends Application {

    public static F1GPCalendarApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerF1GPCalendarApplicationComponent.builder().build();
    }
}
