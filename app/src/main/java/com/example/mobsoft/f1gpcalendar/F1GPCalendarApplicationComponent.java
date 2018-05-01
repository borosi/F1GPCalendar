package com.example.mobsoft.f1gpcalendar;

import com.example.mobsoft.f1gpcalendar.db.DbModule;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.GrandsPrixInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.Guesses.GuessesInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.InteractorModule;
import com.example.mobsoft.f1gpcalendar.network.NetworkModule;
import com.example.mobsoft.f1gpcalendar.ui.UIModule;
import com.example.mobsoft.f1gpcalendar.ui.main.MainActivity;
import com.example.mobsoft.f1gpcalendar.ui.main.MainFragment;
import com.example.mobsoft.f1gpcalendar.ui.main.MainPresenter;
import com.example.mobsoft.f1gpcalendar.ui.newguess.NewGuessFragment;
import com.example.mobsoft.f1gpcalendar.ui.newguess.NewGuessPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, DbModule.class, InteractorModule.class})
public interface F1GPCalendarApplicationComponent {
    void inject(GrandsPrixInteractor grandsPrixInteractor);

    void inject(GuessesInteractor guessesInteractor);

    void inject(MainPresenter mainPresenter);

    void inject(NewGuessPresenter newGuessPresenter);

    void inject(MainFragment mainFragment);

    void inject(NewGuessFragment newGuessFragment);
}
