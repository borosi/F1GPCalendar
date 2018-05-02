package com.example.mobsoft.f1gpcalendar.ui.main;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.di.Network;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.GrandsPrixInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.event.GetGrandsPrixEvent;
import com.example.mobsoft.f1gpcalendar.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;


public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    GrandsPrixInteractor grandsPrixInteractor;

    @Override
    public void attachScreen(MainScreen screen) {
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

    public void loadGrandsPrix() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                grandsPrixInteractor.getGrandsPrix();
            }
        });
    }

    public void navigateToCreateNewGuess() {}

    public void navigateToShowGuesses() {}

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetGrandsPrixEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showGrandsPrix(event.getRaces());
            }
        }
    }
}
