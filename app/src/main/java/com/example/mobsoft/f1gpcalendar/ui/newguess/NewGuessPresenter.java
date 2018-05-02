package com.example.mobsoft.f1gpcalendar.ui.newguess;


import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.di.Network;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.GrandsPrixInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.event.GetDriversInSeasonEvent;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.event.GetGrandsPrixEvent;
import com.example.mobsoft.f1gpcalendar.interactor.Guesses.GuessesInteractor;
import com.example.mobsoft.f1gpcalendar.interactor.Guesses.event.SaveGuessSuccessfulEvent;
import com.example.mobsoft.f1gpcalendar.model.Guess;
import com.example.mobsoft.f1gpcalendar.model.Race;
import com.example.mobsoft.f1gpcalendar.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class NewGuessPresenter extends Presenter<NewGuessScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    GrandsPrixInteractor grandsPrixInteractor;

    @Inject
    GuessesInteractor guessesInteractor;

    public void saveGuess(Guess guess) {
        guessesInteractor.saveGuess(guess);
    }

    @Override
    public void attachScreen(NewGuessScreen screen) {
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

    public void loadDrivers() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                grandsPrixInteractor.getDriversInSeason(2018);
            }
        });
    }

    public void getNextRace() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                grandsPrixInteractor.getGrandsPrix();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetDriversInSeasonEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.storeDrivers(event.getDrivers());
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final SaveGuessSuccessfulEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showSaveError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showSaveSuccess();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetGrandsPrixEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                Race nextRace = null;
                for(Race r : event.getRaces()) {
                    if(r.getDate().before(new Date())){
                        continue;
                    } else {
                        nextRace = r;
                        break;
                    }
                }

                if(nextRace == null)
                    screen.showNetworkError("Can't find next race.");
                else
                    screen.setNextRace(nextRace);
            }
        }
    }
}
