package com.PregBuddyTask.modelList.retrofitClient.pojo.Signupmodel.signinModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chavali on 2018-03-24.
 */

public class SigninModel {


    @SerializedName("apivalue")
    @Expose
    private SinguinApivalue apivalue;
    @SerializedName("apiresult")
    @Expose
    private Integer apiresult;
    @SerializedName("apimessage")
    @Expose
    private String apimessage;
    @SerializedName("totalcount")
    @Expose
    private Object totalcount;
    @SerializedName("count")
    @Expose
    private Object count;

    public SinguinApivalue getApivalue() {
        return apivalue;
    }

    public void setApivalue(SinguinApivalue apivalue) {
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

    public Object getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Object totalcount) {
        this.totalcount = totalcount;
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = count;
    }
}
