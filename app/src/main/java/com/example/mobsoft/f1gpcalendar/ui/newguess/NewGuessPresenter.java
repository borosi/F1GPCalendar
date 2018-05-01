package com.example.mobsoft.f1gpcalendar.ui.newguess;


import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.interactor.Guesses.GuessesInteractor;
import com.example.mobsoft.f1gpcalendar.model.Guess;
import com.example.mobsoft.f1gpcalendar.ui.Presenter;

import javax.inject.Inject;

public class NewGuessPresenter extends Presenter<NewGuessScreen> {

    @Inject
    GuessesInteractor guessesInteractor;

    public void saveGuess(Guess guess) {
        guessesInteractor.saveGuess(guess);
    }

    @Override
    public void attachScreen(NewGuessScreen screen) {
        super.attachScreen(screen);
        F1GPCalendarApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
