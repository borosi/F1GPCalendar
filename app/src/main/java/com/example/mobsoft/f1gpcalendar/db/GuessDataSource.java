package com.example.mobsoft.f1gpcalendar.db;


import com.example.mobsoft.f1gpcalendar.model.Guess;

import java.util.List;

public interface GuessDataSource {
    public Guess getGuess(long id);

    public List<Guess> getAllGuess();

    public void saveGuess(Guess guess);

    public void updateGuess(Guess newGuess);
}
