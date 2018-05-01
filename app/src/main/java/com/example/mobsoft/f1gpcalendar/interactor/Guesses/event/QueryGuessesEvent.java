package com.example.mobsoft.f1gpcalendar.interactor.Guesses.event;


import com.example.mobsoft.f1gpcalendar.model.Guess;

import java.util.List;

public class QueryGuessesEvent {

    private List<Guess> guesses;
    private Throwable throwable;

    public QueryGuessesEvent() {
    }

    public List<Guess> getGuesses() {
        return guesses;
    }

    public void setGuesses(List<Guess> guesses) {
        this.guesses = guesses;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
