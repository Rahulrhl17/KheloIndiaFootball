package com.viaedge.kheloindiafootball.ApiClient;

import com.viaedge.kheloindiafootball.Model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("user")
    Call<List<UserModel>> login(@Query(value = "_where",encoded = true)String credentials);
}
