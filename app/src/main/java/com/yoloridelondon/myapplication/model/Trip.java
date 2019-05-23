package com.yoloridelondon.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trip {
    @SerializedName("booking_id")
    @Expose
    private String bookingId;
    @SerializedName("journey_date_time")
    @Expose
    private String journeyDateTime;
    @SerializedName("pickup_location")
    @Expose
    private String pickupLocation;
    @SerializedName("dropoff_location")
    @Expose
    private String dropoffLocation;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("number_of_passanger")
    @Expose
    private String numberOfPassanger;
    @SerializedName("passanger_name")
    @Expose
    private String passangerName;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("polyline")
    @Expose
    private String polyline;
    @SerializedName("start_latlng")
    @Expose
    private String startLatlng;
    @SerializedName("end_latlng")
    @Expose
    private String endLatlng;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getJourneyDateTime() {
        return journeyDateTime;
    }

    public void setJourneyDateTime(String journeyDateTime) {
        this.journeyDateTime = journeyDateTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNumberOfPassanger() {
        return numberOfPassanger;
    }

    public void setNumberOfPassanger(String numberOfPassanger) {
        this.numberOfPassanger = numberOfPassanger;
    }

    public String getPassangerName() {
        return passangerName;
    }

    public void setPassangerName(String passangerName) {
        this.passangerName = passangerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    public String getStartLatlng() {
        return startLatlng;
    }

    public void setStartLatlng(String startLatlng) {
        this.startLatlng = startLatlng;
    }

    public String getEndLatlng() {
        return endLatlng;
    }

    public void setEndLatlng(String endLatlng) {
        this.endLatlng = endLatlng;
    }
}
