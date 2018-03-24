package com.PregBuddyTask.modelList.retrofitClient.retrofitclient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chavali on 2018-03-24.
 */

public class ApiClient {
    public static final String BASE_URL = "http://publicapi.talentaccurate.com/guser/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return retrofit;
    }
}
