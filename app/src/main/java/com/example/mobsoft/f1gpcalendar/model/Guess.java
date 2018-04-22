package com.example.mobsoft.f1gpcalendar.model;

import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;
import com.orm.SugarRecord;

public class Guess extends SugarRecord<Guess> {
    Race race;
    Driver first;
    Driver second;
    Driver third;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Driver getFirst() {
        return first;
    }

    public void setFirst(Driver first) {
        this.first = first;
    }

    public Driver getSecond() {
        return second;
    }

    public void setSecond(Driver second) {
        this.second = second;
    }

    public Driver getThird() {
        return third;
    }

    public void setThird(Driver third) {
        this.third = third;
    }
}
