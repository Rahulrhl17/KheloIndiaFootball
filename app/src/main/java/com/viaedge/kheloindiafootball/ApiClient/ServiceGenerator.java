package com.viaedge.kheloindiafootball.ApiClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static String base_url = "http://10.0.2.2:3000/api/";

    private static GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(gsonConverterFactory);
    private static Retrofit retrofit = builder.build();

    public static <S> S login(Class<S> serviceclass, String credentials){
        return retrofit.create(serviceclass);
    }
}
