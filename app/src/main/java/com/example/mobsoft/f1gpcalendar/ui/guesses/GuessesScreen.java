package com.example.mobsoft.f1gpcalendar.ui.guesses;


import com.example.mobsoft.f1gpcalendar.model.Guess;

import java.util.List;

public interface GuessesScreen {
    void showGuesses(List<Guess> guesses);

    void showError(String message);
}
