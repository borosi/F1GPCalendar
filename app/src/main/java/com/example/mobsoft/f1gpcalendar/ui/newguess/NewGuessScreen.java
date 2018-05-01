package com.example.mobsoft.f1gpcalendar.ui.newguess;


import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;
import com.example.mobsoft.f1gpcalendar.model.Race;

import java.util.List;

public interface NewGuessScreen {
    void showSaveSuccess();

    void showSaveError(String message);

    void showNetworkError(String message);

    void storeDrivers(List<Driver> drivers);

    void setNextRace(Race nextRace);
}
