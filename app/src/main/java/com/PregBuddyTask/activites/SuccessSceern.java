package com.PregBuddyTask.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.PregBuddyTask.R;
import com.PregBuddyTask.backgroudServices.MyJobService;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

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


        mDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
        scheduleJob();
    }

    private void scheduleJob() {
        //Job Scheduler To show the tips at every time interval of time
        Job myJob = mDispatcher.newJobBuilder()
                .setService(MyJobService.class)
                .setTag(JOB_TAG)
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(5, 25))
                .setLifetime(Lifetime.FOREVER)
                .setReplaceCurrent(false)
                .setConstraints(Constraint.ON_ANY_NETWORK)
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                .build();

        mDispatcher.mustSchedule(myJob);
        Toast.makeText(this, "Schedulde Started", Toast.LENGTH_LONG).show();

    }
}
