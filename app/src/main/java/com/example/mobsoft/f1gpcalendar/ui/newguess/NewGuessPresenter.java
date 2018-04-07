package com.example.mobsoft.f1gpcalendar.ui.newguess;


import com.example.mobsoft.f1gpcalendar.interactor.Guesses.GuessesInteractor;
import com.example.mobsoft.f1gpcalendar.ui.Presenter;

import javax.inject.Inject;

public class NewGuessPresenter extends Presenter<NewGuessScreen> {

    @Inject
    GuessesInteractor guessesInteractor;

    public void saveGuess() {}

    public void navigateToMain() {}
}
