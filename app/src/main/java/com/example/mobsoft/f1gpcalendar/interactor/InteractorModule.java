package com.example.mobsoft.f1gpcalendar.interactor;

import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.GrandsPrixInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public GrandsPrixInteractor provideGrandsPrixInteractor() { return new GrandsPrixInteractor(); }
}
