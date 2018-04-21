package com.example.mobsoft.f1gpcalendar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSeasonDataResponse {
    @SerializedName("MRData")
    @Expose
    private MRData mRData;

    public MRData getMRData() {
        return mRData;
    }

    public void setMRData(MRData mRData) {
        this.mRData = mRData;
    }
}
