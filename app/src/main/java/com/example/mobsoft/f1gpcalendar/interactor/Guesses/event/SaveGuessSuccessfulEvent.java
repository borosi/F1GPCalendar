package com.example.mobsoft.f1gpcalendar.interactor.Guesses.event;

import com.example.mobsoft.f1gpcalendar.model.Guess;

import java.util.List;

public class SaveGuessSuccessfulEvent {
    private Throwable throwable;

    public SaveGuessSuccessfulEvent() {
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
