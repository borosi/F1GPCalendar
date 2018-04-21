package com.example.mobsoft.f1gpcalendar.network;

import com.example.mobsoft.f1gpcalendar.model.MRData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GrandsPrixApi {
  
  /**
   * Get a season by year
   * Obtain the schedule of races for a specific season.
   * @param id Year of the season to get
   * @return Call<MRData>
   */
  
  @GET("api/f1/{id}")
  Call<MRData> getGrandsPrix(
    @Path("id") Integer id
  );
  
}
