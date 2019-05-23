package com.yoloridelondon.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TripHistory {

    @SerializedName("rs")
    @Expose
    private Integer rs;
    @SerializedName("data")
    @Expose
    private List<Trip> data = null;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public Integer getRs() {
        return rs;
    }

    public void setRs(Integer rs) {
        this.rs = rs;
    }

    public List<Trip> getData() {
        return data;
    }

    public void setData(List<Trip> data) {
        this.data = data;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
