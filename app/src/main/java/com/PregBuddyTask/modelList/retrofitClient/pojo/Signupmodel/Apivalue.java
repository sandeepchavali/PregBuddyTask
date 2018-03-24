package com.PregBuddyTask.modelList.retrofitClient.pojo.Signupmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chavali on 2018-03-24.
 */

public class Apivalue {

    @SerializedName("TOKEN")
    @Expose
    private String tOKEN;

    public String getTOKEN() {
        return tOKEN;
    }

    public void setTOKEN(String tOKEN) {
        this.tOKEN = tOKEN;
    }
}
