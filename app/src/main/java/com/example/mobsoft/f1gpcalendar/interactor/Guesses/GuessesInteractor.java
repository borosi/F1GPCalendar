package com.example.mobsoft.f1gpcalendar.interactor.Guesses;


import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;

import javax.inject.Inject;

public class GuessesInteractor {

    @Inject


    public GuessesInteractor() { F1GPCalendarApplication.injector.inject(this); }

    public void queryGuesses() {}

    public void saveGuess() {}
}
