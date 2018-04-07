package com.example.mobsoft.f1gpcalendar.ui.guesses;

import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.GrandsPrixInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.Guesses.GuessesInteractor;
import com.example.mobsoft.f1gpcalendar.ui.Presenter;

import javax.inject.Inject;


public class GuessesPresenter extends Presenter<GuessesScreen> {

    @Inject
    GrandsPrixInteractor grandsPrixInteractor;

    @Inject
    GuessesInteractor guessesInteractor;

    public void showGuesses() {}

    public void navigateToMain() {}
}
