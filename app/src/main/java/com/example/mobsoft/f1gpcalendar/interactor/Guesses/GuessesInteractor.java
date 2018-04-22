package com.example.mobsoft.f1gpcalendar.interactor.Guesses;


import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.db.GuessDataSource;

import javax.inject.Inject;

public class GuessesInteractor {

    @Inject
    GuessDataSource guessDataSource;

    public GuessesInteractor() { F1GPCalendarApplication.injector.inject(this); }

    public void queryGuesses() {}

    public void saveGuess() {}
}
