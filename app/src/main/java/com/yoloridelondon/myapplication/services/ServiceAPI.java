package com.yoloridelondon.myapplication.services;

import com.yoloridelondon.myapplication.model.TripHistory;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceAPI {

    @FormUrlEncoded
    @POST("pda/getUserInvoice")
    Observable<TripHistory> getTripHistory(@Field("email") String email);
}
