
package com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverTable {

    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("Drivers")
    @Expose
    private List<Driver> drivers = null;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

}
