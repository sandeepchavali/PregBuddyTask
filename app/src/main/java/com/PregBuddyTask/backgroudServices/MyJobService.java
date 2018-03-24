package com.PregBuddyTask.backgroudServices;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import com.PregBuddyTask.R;
import com.PregBuddyTask.activites.LoginActivity;
import com.PregBuddyTask.modelList.retrofitClient.ormModel.NotificationTips;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chavali on 2018-03-24.
 */

public class MyJobService extends JobService {

    // This is for the job dispather service call for the processing the in background

    private static final String TAG = "MyJobService";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        // Start the Job if the thelocal data is more than 0
        List<NotificationTips> notificationTips = NotificationTips.listAll(NotificationTips.class);
        Log.e("job seervice", String.valueOf(notificationTips.size()));

        if (notificationTips.size() != 0) {
            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
            Log.e(TAG, currentDateTimeString);


            createNotification(currentDateTimeString, currentDateTimeString);
        }

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.e(TAG, "Job cancelled!");
        return false;
    }


    public void createNotification(String title, String message) {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, LoginActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        // Build notification
        Notification noti = new Notification.Builder(this)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_event_note_black_24dp)
                .setContentIntent(pIntent)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }

}
