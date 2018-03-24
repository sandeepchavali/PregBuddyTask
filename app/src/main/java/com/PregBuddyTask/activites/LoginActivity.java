package com.PregBuddyTask.activites;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.PregBuddyTask.R;
import com.PregBuddyTask.modelList.retrofitClient.pojo.Signupmodel.signinModel.SigninModel;
import com.PregBuddyTask.modelList.retrofitClient.retrofitclient.ApiClient;
import com.PregBuddyTask.modelList.retrofitClient.retrofitclient.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Typeface regular, bold;
    Button loginBtn, signupBtn;
    EditText username_et, userpassword_et;
    TextInputLayout username_il, userpassword_il;
    String username, password, APIKEY;
    private Dialog dialog;
    private ProgressBar mProgressView;


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        APIKEY = "4834364d322a642e3c2f5a7c20";
        inti();
        loginBtn.setOnClickListener(this);
        signupBtn.setOnClickListener(this);
    }

    public void inti() {
        regular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/aller_Rg.ttf");
        bold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/aller_Bd.ttf");

        loginBtn = findViewById(R.id.loginBtn);
        signupBtn = findViewById(R.id.signupBtn);
        username_et = findViewById(R.id.username_et);
        userpassword_et = findViewById(R.id.userpassword_et);
        username_il = findViewById(R.id.username_il);
        userpassword_il = findViewById(R.id.userpassword_il);

        loginBtn.setTypeface(bold);
        signupBtn.setTypeface(bold);
        username_et.setTypeface(regular);
        userpassword_et.setTypeface(regular);
        username_il.setTypeface(regular);
        userpassword_il.setTypeface(regular);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.loginBtn:
                // calling the webservice for login after validation

                if (validateLogin()) {
                    if (isNetworkAvailable(LoginActivity.this)) {
                        showProgressBar();
                        LoginCallWs(username, password);

                    } else {

                        Toast.makeText(getApplicationContext(), getString(R.string.no_connection), Toast.LENGTH_SHORT).show();

                    }
                }
                break;

            case R.id.signupBtn:
                // calling then signup actiivity
                Intent signup = new Intent(LoginActivity.this, SignUp.class);
                startActivity(signup);
                break;

        }
    }

    public Boolean validateLogin() {

        if (username_et.getText().toString().length() < 1) {
            username_il.setError("Enter User Name");
            username_il.setErrorEnabled(true);

            return false;

        } else if (userpassword_et.getText().toString().length() < 3) {
            userpassword_il.setError("Enter Password more than 3 characters");
            userpassword_il.setErrorEnabled(true);
            username_il.setErrorEnabled(false);

            return false;

        } else {
            userpassword_il.setErrorEnabled(false);
        }

        username = username_et.getText().toString();
        password = userpassword_et.getText().toString();

        return true;
    }

    public void LoginCallWs(String username, String password) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<SigninModel> loginws = apiService.callLogin(APIKEY, username, password);
        loginws.enqueue(new Callback<SigninModel>() {
            @Override
            public void onResponse(Call<SigninModel> call, Response<SigninModel> response) {
                hideProgress();
                if (response.isSuccessful()) {
                    Log.e("get api result", String.valueOf(response.body().getApiresult()));
                    Toast.makeText(getApplicationContext(), response.body().getApimessage(), Toast.LENGTH_LONG).show();


                    if (response.body().getApiresult() == 0) {
                        // on sucess call back procede to next actvity

                        Intent successResponse = new Intent(LoginActivity.this, SuccessSceern.class);
                        startActivity(successResponse);

                    }
                }

            }

            @Override
            public void onFailure(Call<SigninModel> call, Throwable t) {
                hideProgress();
                Toast.makeText(getApplicationContext(), getString(R.string.faliure_message), Toast.LENGTH_LONG).show();

            }
        });


    }


    private void showProgressBar() {

        dialog = new Dialog(LoginActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_progressbar_layout);
        dialog.setCancelable(false);
        mProgressView = (ProgressBar) dialog.findViewById(R.id.progress_dialog);
        mProgressView.setVisibility(View.VISIBLE);
        dialog.show();

    }

    private void hideProgress() {

        if ((dialog != null) && dialog.isShowing()) {
            dialog.dismiss();
            mProgressView.setVisibility(View.GONE);
        }
    }
}
