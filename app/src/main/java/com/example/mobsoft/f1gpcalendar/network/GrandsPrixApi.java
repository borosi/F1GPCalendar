package com.example.mobsoft.f1gpcalendar.network;

import io.swagger.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import io.swagger.client.model.MRData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
