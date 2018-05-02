package com.example.mobsoft.f1gpcalendar;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        F1GPCalendarApplication application = (F1GPCalendarApplication) RuntimeEnvironment.application;
        F1GPCalendarApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
    }
}
