package com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix;


import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.network.GrandsPrixApi;

import javax.inject.Inject;

public class GrandsPrixInteractor {

    @Inject
    GrandsPrixApi grandsPrixApi;

    public GrandsPrixInteractor() { F1GPCalendarApplication.injector.inject(this); }

    public void getGrandsPrix() {}

    public void getGrandPrixResult(int round) {}
}
