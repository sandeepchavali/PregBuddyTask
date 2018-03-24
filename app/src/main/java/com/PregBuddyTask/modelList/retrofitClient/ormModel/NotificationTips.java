package com.PregBuddyTask.modelList.retrofitClient.ormModel;


import com.orm.SugarRecord;

/**
 * Created by chavali on 2018-03-24.
 */

public class NotificationTips extends SugarRecord {

    String title, data;

    public NotificationTips() {
    }

    public NotificationTips(String title, String data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
