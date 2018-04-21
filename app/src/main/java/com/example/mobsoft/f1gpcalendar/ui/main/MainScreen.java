package com.example.mobsoft.f1gpcalendar.ui.main;


import com.example.mobsoft.f1gpcalendar.model.Race;

import java.util.List;

public interface MainScreen {
    void showGrandsPrix(List<Race> races);

    void showNetworkError(String errorMsg);
}
