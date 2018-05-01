package com.example.mobsoft.f1gpcalendar.ui.newguess;


import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;

import java.util.List;

public interface NewGuessScreen {
    void showSaveSuccess();

    void showSaveError();

    void showNetworkError(String message);

    void storeDrivers(List<Driver> drivers);
}
