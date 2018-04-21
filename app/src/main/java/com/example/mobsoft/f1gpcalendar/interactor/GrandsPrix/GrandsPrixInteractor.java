package com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix;


import retrofit2.Call;
import retrofit2.Response;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.event.GetDriversInSeasonEvent;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.event.GetGrandsPrixEvent;
import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.GetDriversInSeasonData;
import com.example.mobsoft.f1gpcalendar.model.GetSeasonDataResponse;
import com.example.mobsoft.f1gpcalendar.model.MRData;
import com.example.mobsoft.f1gpcalendar.network.GrandsPrixApi;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

public class GrandsPrixInteractor {

    @Inject
    GrandsPrixApi grandsPrixApi;

    public GrandsPrixInteractor() { F1GPCalendarApplication.injector.inject(this); }

    public void getGrandsPrix() {
        GetGrandsPrixEvent event = new GetGrandsPrixEvent();
        try {
            Call<GetSeasonDataResponse> seasonQueryCall = grandsPrixApi.getGrandsPrix(2018);

            Response<GetSeasonDataResponse> response = seasonQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setRaces(response.body().getMRData().getRaceTable().getRaces());
        } catch (Exception e) {
            event.setThrowable(e);
        } finally {
            EventBus.getDefault().post(event);
        }
    }

    public void getGrandPrixResult(int round) {}

    public void getDriversInSeason(int round) {
        GetDriversInSeasonEvent event = new GetDriversInSeasonEvent();
        try {
            Call<GetDriversInSeasonData> driversQueryCall = grandsPrixApi.getDriversInSeason(2018);

            Response<GetDriversInSeasonData> response = driversQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setDrivers(response.body().getMRData().getDriverTable().getDrivers());
        } catch (Exception e) {
            event.setThrowable(e);
        } finally {
            EventBus.getDefault().post(event);
        }

    }
}
