package com.example.mobsoft.f1gpcalendar.utils;

import com.example.mobsoft.f1gpcalendar.model.Circuit;
import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;
import com.example.mobsoft.f1gpcalendar.model.Guess;
import com.example.mobsoft.f1gpcalendar.model.Location;
import com.example.mobsoft.f1gpcalendar.model.Race;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DbData {
    public static Guess getExampleGuess() {
        Race race = new Race();
        race.setSeason(2018);
        race.setRound(1);
        race.setUrl("http://en.wikipedia.org/wiki/2018_Australian_Grand_Prix");
        race.setRaceName("Australian Grand Prix");

        Circuit circuit = new Circuit();
        circuit.setCircuitId("albert_park");
        circuit.setUrl("http://en.wikipedia.org/wiki/Melbourne_Grand_Prix_Circuit");
        circuit.setCircuitName("Albert Park Grand Prix Circuit");

        Location location = new Location();
        location.setLat(-37.8497);
        location.setLong(144.968);
        location.setLocality("Melbourne");
        location.setCountry("Australia");

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse("2018-03-25");
            race.setDate(date);
        } catch (Exception e) {
            race.setDate(new Date("2018-03-25"));
        }

        race.setTime("05:10:00Z");

        Driver alonso = new Driver();
        alonso.setDriverId("alonso");
        alonso.setPermanentNumber("14");
        alonso.setCode("ALO");
        alonso.setUrl("http://en.wikipedia.org/wiki/Fernando_Alonso");
        alonso.setGivenName("Fernando");
        alonso.setFamilyName("Alonso");
        alonso.setDateOfBirth("1981-07-29");
        alonso.setNationality("Spanish");

        Driver bottas = new Driver();
        bottas.setDriverId("bottas");
        bottas.setPermanentNumber("77");
        bottas.setCode("BOT");
        bottas.setUrl("http://en.wikipedia.org/wiki/Valtteri_Bottas");
        bottas.setGivenName("Valtteri");
        bottas.setFamilyName("Bottas");
        bottas.setDateOfBirth("1989-08-28");
        bottas.setNationality("Finnish");

        Driver ericsson = new Driver();
        ericsson.setDriverId("ericsson");
        ericsson.setPermanentNumber("9");
        ericsson.setCode("ERI");
        ericsson.setUrl("http://en.wikipedia.org/wiki/Marcus_Ericsson");
        ericsson.setGivenName("Marcus");
        ericsson.setFamilyName("Ericsson");
        ericsson.setDateOfBirth("1990-09-02");
        ericsson.setNationality("Swedish");

        Guess guess = new Guess();
        guess.setRace(race);
        guess.setFirst(alonso);
        guess.setSecond(bottas);
        guess.setThird(ericsson);

        return guess;
    }
}
