package com.PregBuddyTask.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.PregBuddyTask.R;
import com.PregBuddyTask.backgroudServices.MyJobService;
import com.PregBuddyTask.modelList.retrofitClient.ormModel.NotificationTips;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;
import com.orm.SugarContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
* This class is used to store data in the data base and call the job dispacther for frequent interval of time
*
* */
public class SuccessSceern extends AppCompatActivity {

    private static final String JOB_TAG = "MyJobService";
    private FirebaseJobDispatcher mDispatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_sceern);
        SugarContext.init(this);

        /*This codition will check the size of database if the database is zero load the storage is zero*/

        List<NotificationTips> notificationTips = NotificationTips.listAll(NotificationTips.class);

        if (notificationTips.size() == 0) {
            try {
                JSONObject loadobject = new JSONObject(loadJSONFromAsset());

                JSONArray responseArray = loadobject.getJSONArray("response");

                for (int i = 0; i < responseArray.length(); i++) {

                    String title = responseArray.getJSONObject(i).getString("title");
                    String data = responseArray.getJSONObject(i).getString("data");

                    NotificationTips tips = new NotificationTips(title, data);
                    tips.save();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            List<NotificationTips> notificationTips2 = NotificationTips.listAll(NotificationTips.class);
            Log.e("notificationTips 2", String.valueOf(notificationTips2.size()));

            // to intilazie the job dispacther
            mDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
            // Start Schedule Job
            scheduleJob();
        }

    }

    private void scheduleJob() {
        //Job Scheduler To show the tips at every time interval of time
        Job myJob = mDispatcher.newJobBuilder()
                .setService(MyJobService.class)
                .setTag(JOB_TAG)
                .setRecurring(true)
//                .setTrigger(Trigger.executionWindow(60*60*24,60*60*24+60))
                .setTrigger(Trigger.executionWindow(60, 60 * 60))
                .setLifetime(Lifetime.FOREVER)
                .setReplaceCurrent(false)
                .setConstraints(Constraint.ON_ANY_NETWORK)
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                .build();

        mDispatcher.mustSchedule(myJob);
        Toast.makeText(this, "Schedulde Started", Toast.LENGTH_LONG).show();

    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("tips.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
