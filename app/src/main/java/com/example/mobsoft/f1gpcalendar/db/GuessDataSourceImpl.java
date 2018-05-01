package com.example.mobsoft.f1gpcalendar.db;

import android.util.Log;

import com.example.mobsoft.f1gpcalendar.model.Guess;

import java.util.List;

public class GuessDataSourceImpl implements GuessDataSource{

    public Guess getGuess(long id) {
        return Guess.findById(Guess.class, id);
    }

    public List<Guess> getAllGuess() {
        return Guess.listAll(Guess.class);
    }

    public void saveGuess(Guess guess) {
        guess.getFirst().save();
        guess.getSecond().save();
        guess.getThird().save();
        guess.save();
    }

    public void updateGuess(Guess newGuess){
        Guess oldGuess = Guess.findById(Guess.class, newGuess.getId());
        oldGuess.setFirst(newGuess.getFirst());
        oldGuess.setSecond(newGuess.getSecond());
        oldGuess.setThird(newGuess.getThird());
        oldGuess.save();
    }
}
