package com.PregBuddyTask.modelList.retrofitClient.pojo.Signupmodel.signinModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chavali on 2018-03-24.
 */

public class SinguinApivalue {

    @SerializedName("usergroup")
    @Expose
    private Integer usergroup;
    @SerializedName("session_expires_at")
    @Expose
    private Long sessionExpiresAt;
    @SerializedName("sessionid")
    @Expose
    private String sessionid;
    @SerializedName("userid")
    @Expose
    private Integer userid;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Integer getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(Integer usergroup) {
        this.usergroup = usergroup;
    }

    public Long getSessionExpiresAt() {
        return sessionExpiresAt;
    }

    public void setSessionExpiresAt(Long sessionExpiresAt) {
        this.sessionExpiresAt = sessionExpiresAt;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
