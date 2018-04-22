package com.example.mobsoft.f1gpcalendar.mock.network;

import com.example.mobsoft.f1gpcalendar.model.Circuit;
import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;
import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.DriverTable;
import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.GetDriversInSeasonData;
import com.example.mobsoft.f1gpcalendar.model.GetSeasonDataResponse;
import com.example.mobsoft.f1gpcalendar.model.Location;
import com.example.mobsoft.f1gpcalendar.model.MRData;
import com.example.mobsoft.f1gpcalendar.model.Race;
import com.example.mobsoft.f1gpcalendar.model.RaceTable;
import com.example.mobsoft.f1gpcalendar.network.GrandsPrixApi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MockGrandsPrixApi implements GrandsPrixApi {
    @Override
    public Call<GetSeasonDataResponse> getGrandsPrix(Integer id) {
        final GetSeasonDataResponse result = new GetSeasonDataResponse();

        MRData mrData = new MRData();
        mrData.setXmlns("http://ergast.com/mrd/1.4");
        mrData.setSeries("f1");
        mrData.setUrl("http://ergast.com/api/f1/2018.json");
        mrData.setLimit(30);
        mrData.setOffset(0);
        mrData.setTotal(21);

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

        List<Race> races = new ArrayList<Race>();
        RaceTable raceTable = new RaceTable();
        raceTable.setSeason(2018);
        raceTable.setRaces(races);
        result.setMRData(mrData);

        Call<GetSeasonDataResponse> call = new Call<GetSeasonDataResponse>() {
            @Override
            public Response<GetSeasonDataResponse> execute() throws IOException {
                return Response.success(result);
            }

            @Override
            public void enqueue(Callback<GetSeasonDataResponse> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<GetSeasonDataResponse> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<GetDriversInSeasonData> getDriversInSeason(Integer id) {
        final GetDriversInSeasonData result = new GetDriversInSeasonData();

        com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.MRData mrData =
                new com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.MRData();
        mrData.setXmlns("http://ergast.com/mrd/1.4");
        mrData.setSeries("f1");
        mrData.setUrl("http://ergast.com/api/f1/2018/drivers.json");
        mrData.setLimit("30");
        mrData.setOffset("0");
        mrData.setTotal("20");

        List<Driver> drivers = new ArrayList<Driver>();
        
        Driver alonso = new Driver();
        alonso.setDriverId("alonso");
        alonso.setPermanentNumber("14");
        alonso.setCode("ALO");
        alonso.setUrl("http://en.wikipedia.org/wiki/Fernando_Alonso");
        alonso.setGivenName("Fernando");
        alonso.setFamilyName("Alonso");
        alonso.setDateOfBirth("1981-07-29");
        alonso.setNationality("Spanish");
        drivers.add(alonso);
        
        Driver bottas = new Driver();
        bottas.setDriverId("bottas");
        bottas.setPermanentNumber("77");
        bottas.setCode("BOT");
        bottas.setUrl("http://en.wikipedia.org/wiki/Valtteri_Bottas");
        bottas.setGivenName("Valtteri");
        bottas.setFamilyName("Bottas");
        bottas.setDateOfBirth("1989-08-28");
        bottas.setNationality("Finnish");
        drivers.add(bottas);

        Driver ericsson = new Driver();
        ericsson.setDriverId("ericsson");
        ericsson.setPermanentNumber("9");
        ericsson.setCode("ERI");
        ericsson.setUrl("http://en.wikipedia.org/wiki/Marcus_Ericsson");
        ericsson.setGivenName("Marcus");
        ericsson.setFamilyName("Ericsson");
        ericsson.setDateOfBirth("1990-09-02");
        ericsson.setNationality("Swedish");
        drivers.add(ericsson);

        DriverTable driverTable = new DriverTable();
        driverTable.setSeason("2018");
        driverTable.setDrivers(drivers);

        mrData.setDriverTable(driverTable);

        result.setMRData(mrData);

        Call<GetDriversInSeasonData> call = new Call<GetDriversInSeasonData>() {
            @Override
            public Response<GetDriversInSeasonData> execute() throws IOException {
                return Response.success(result);
            }

            @Override
            public void enqueue(Callback<GetDriversInSeasonData> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<GetDriversInSeasonData> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }
}
