package com.example.mobsoft.f1gpcalendar;

import com.example.mobsoft.f1gpcalendar.ui.UIModule;
import com.orm.SugarApp;

public class F1GPCalendarApplication extends SugarApp {

    public static F1GPCalendarApplicationComponent injector;

    @Override
    public void onCreate() {
//    if(false)
        super.onCreate();

        injector = DaggerF1GPCalendarApplicationComponent.builder().
                uIModule(
                        new UIModule(this)
                ).build();
    }
}
