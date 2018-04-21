package com.example.mobsoft.f1gpcalendar.ui.main;

import com.example.mobsoft.f1gpcalendar.di.Network;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.GrandsPrixInteractor;
import com.example.mobsoft.f1gpcalendar.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;


public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    GrandsPrixInteractor grandsPrixInteractor;

    public void loadGrandsPrix() {}

    public void navigateToCreateNewGuess() {}

    public void navigateToShowGuesses() {}
}
