package com.example.mobsoft.f1gpcalendar.model;

import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;
import com.orm.SugarRecord;

public class Guess extends SugarRecord<Guess> {
    Race race;
    Driver first;
    Driver second;
    Driver third;
}
