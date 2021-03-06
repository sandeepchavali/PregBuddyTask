package com.PregBuddyTask.modelList.retrofitClient.pojo.Signupmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chavali on 2018-03-24.
 */

public class SignupModel {

    @SerializedName("apivalue")
    @Expose
    private Apivalue apivalue;
    @SerializedName("apiresult")
    @Expose
    private Integer apiresult;
    @SerializedName("apimessage")
    @Expose
    private String apimessage;


    public Apivalue getApivalue() {
        return apivalue;
    }

    public void setApivalue(Apivalue apivalue) {
        this.apivalue = apivalue;
    }

    public Integer getApiresult() {
        return apiresult;
    }

    public void setApiresult(Integer apiresult) {
        this.apiresult = apiresult;
    }

    public String getApimessage() {
        return apimessage;
    }

    public void setApimessage(String apimessage) {
        this.apimessage = apimessage;
    }


}
