package com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.event;

import com.example.mobsoft.f1gpcalendar.model.Race;

import java.util.List;

public class GetGrandsPrixEvent {
    private int code;
    private List<Race> races;
    private Throwable throwable;

    public GetGrandsPrixEvent() {
    }

    public GetGrandsPrixEvent(int code, List<Race> races, Throwable throwable) {
        this.code = code;
        this.races = races;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
