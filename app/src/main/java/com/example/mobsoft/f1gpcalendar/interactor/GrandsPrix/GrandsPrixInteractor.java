package com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix;


import retrofit2.Call;
import retrofit2.Response;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.interactor.GrandsPrix.event.GetGrandsPrixEvent;
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
            Call<MRData> seasonQueryCall = grandsPrixApi.getGrandsPrix(2018);

            Response<MRData> response = seasonQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setRaces(response.body().getRaceTable().getRaces());
        } catch (Exception e) {
            event.setThrowable(e);
        } finally {
            EventBus.getDefault().post(event);
        }
    }

    public void getGrandPrixResult(int round) {}
}
