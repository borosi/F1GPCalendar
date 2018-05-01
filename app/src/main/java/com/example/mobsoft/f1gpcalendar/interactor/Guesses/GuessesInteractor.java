package com.example.mobsoft.f1gpcalendar.interactor.Guesses;


import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.db.GuessDataSource;
import com.example.mobsoft.f1gpcalendar.interactor.Guesses.event.QueryGuessesEvent;
import com.example.mobsoft.f1gpcalendar.model.Guess;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

public class GuessesInteractor {

    @Inject
    GuessDataSource guessDataSource;

    public GuessesInteractor() { F1GPCalendarApplication.injector.inject(this); }

    public void queryGuesses() {
        QueryGuessesEvent event = new QueryGuessesEvent();
        try {
            event.setGuesses(guessDataSource.getAllGuess());
        } catch(Exception e) {
            event.setThrowable(e);
        } finally {
            EventBus.getDefault().post(event);
        }
    }

    public void saveGuess(Guess guess) {
        try {
            guessDataSource.saveGuess(guess);
        } catch(Exception e) {

        } finally {

        }
    }
}
