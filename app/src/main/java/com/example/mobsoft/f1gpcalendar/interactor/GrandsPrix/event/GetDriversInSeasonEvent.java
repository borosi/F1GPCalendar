package com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.event;


import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;

import java.util.List;

public class GetDriversInSeasonEvent {
    private int code;
    private List<Driver> drivers;
    private Throwable throwable;

    public GetDriversInSeasonEvent() {
    }

    public GetDriversInSeasonEvent(int code, List<Driver> drivers, Throwable throwable) {
        this.code = code;
        this.drivers = drivers;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> races) {
        this.drivers = races;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
