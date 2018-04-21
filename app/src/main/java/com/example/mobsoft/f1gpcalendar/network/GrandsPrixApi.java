package com.example.mobsoft.f1gpcalendar.network;

import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.GetDriversInSeasonData;
import com.example.mobsoft.f1gpcalendar.model.GetSeasonDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GrandsPrixApi {

    /**
     * Get a season by year
     * Obtain the schedule of races for a specific season.
     *
     * @param id Year of the season to get
     * @return Call<MRData>
     */

    @GET("api/f1/{id}.json")
    Call<GetSeasonDataResponse> getGrandsPrix(
            @Path("id") Integer id
    );

    @GET("api/f1/{id}.json")
    Call<GetDriversInSeasonData> getDriversInSeason(
            @Path("id") Integer id
    );

}
