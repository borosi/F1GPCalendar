package com.example.mobsoft.f1gpcalendar.mock.db;


import com.example.mobsoft.f1gpcalendar.db.GuessDataSource;
import com.example.mobsoft.f1gpcalendar.model.Circuit;
import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;
import com.example.mobsoft.f1gpcalendar.model.Guess;
import com.example.mobsoft.f1gpcalendar.model.Location;
import com.example.mobsoft.f1gpcalendar.model.Race;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockGuessDataSourceImpl implements GuessDataSource{
    List<Guess> guesses = new ArrayList<Guess>();

    @Override
    public Guess getGuess(long id) {
        return null;
    }

    @Override
    public List<Guess> getAllGuess() {
        return guesses;
    }

    @Override
    public void saveGuess(Guess guess) throws Exception {
        if(guess == null) throw new Exception("Guess should not be null");
        guesses.add(guess);
    }

    @Override
    public void updateGuess(Guess newGuess) {
        for(Guess g : guesses){
            if(g.getId() == newGuess.getId()){
                g.setFirst(newGuess.getFirst());
                g.setSecond(newGuess.getSecond());
                g.setThird(newGuess.getThird());
            }
        }
    }
}
