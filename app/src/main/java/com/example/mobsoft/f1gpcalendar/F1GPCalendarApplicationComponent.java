package com.example.mobsoft.f1gpcalendar;

import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.GrandsPrixInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.Guesses.GuessesInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.InteractorModule;
import com.example.mobsoft.f1gpcalendar.network.NetworkModule;
import com.example.mobsoft.f1gpcalendar.ui.UIModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {InteractorModule.class, UIModule.class, NetworkModule.class})
public interface F1GPCalendarApplicationComponent {
    void inject(GrandsPrixInteractor grandsPrixInteractor);

    void inject(GuessesInteractor guessesInteractor);
}
