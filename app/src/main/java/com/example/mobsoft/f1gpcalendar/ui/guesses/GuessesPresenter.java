package com.example.mobsoft.f1gpcalendar.ui.guesses;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.GrandsPrixInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.Guesses.GuessesInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.Guesses.event.QueryGuessesEvent;
import com.example.mobsoft.f1gpcalendar.model.Guess;
import com.example.mobsoft.f1gpcalendar.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;


public class GuessesPresenter extends Presenter<GuessesScreen> {

    @Inject
    GrandsPrixInteractor grandsPrixInteractor;

    @Inject
    GuessesInteractor guessesInteractor;

    @Override
    public void attachScreen(GuessesScreen screen) {
        super.attachScreen(screen);
        F1GPCalendarApplication.injector.inject(this);
        if(!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void queryGuesses() {
        guessesInteractor.queryGuesses();
    }

    public void showNewGuessScreen() {
        screen.showNewGuessScreen();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final QueryGuessesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showGuesses(event.getGuesses());
            }
        }
    }

}
