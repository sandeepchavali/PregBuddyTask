package com.PregBuddyTask.modelList.retrofitClient.retrofitclient;

import com.PregBuddyTask.modelList.retrofitClient.pojo.Signupmodel.signinModel.SigninModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by chavali on 2018-03-24.
 */

public interface ApiInterface {


    @FormUrlEncoded
    @POST("login/json")
    Call<SigninModel> callLogin(@Query("apikey") String apikey,
                                @Field("username") String username,
                                @Field("password") String password);
}

