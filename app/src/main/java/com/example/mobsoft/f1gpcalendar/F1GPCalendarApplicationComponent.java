package com.example.mobsoft.f1gpcalendar;

import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.GrandsPrixInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.InteractorModule;
import com.example.mobsoft.f1gpcalendar.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, InteractorModule.class})
public interface F1GPCalendarApplicationComponent {
    void inject(GrandsPrixInteractor grandsPrixInteractor);
}
