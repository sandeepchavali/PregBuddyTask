package com.PregBuddyTask.activites;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.PregBuddyTask.R;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    Typeface regular, bold;
    Button signup_signupBtn, signup_loginbtn;
    EditText username_et, userpassword_et;
    TextInputLayout username_il, userpassword_il;

    String username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inti();

        signup_signupBtn.setOnClickListener(this);
        signup_loginbtn.setOnClickListener(this);

    }

    public void inti() {

        regular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/aller_Rg.ttf");
        bold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/aller_Bd.ttf");

        signup_signupBtn = findViewById(R.id.signup_signupBtn);
        signup_loginbtn = findViewById(R.id.signup_loginbtn);
        username_et = findViewById(R.id.signup_username_et);
        userpassword_et = findViewById(R.id.signup_userpassword_et);
        username_il = findViewById(R.id.signup_username_il);
        userpassword_il = findViewById(R.id.signup_userpassword_il);

        signup_signupBtn.setTypeface(bold);
        signup_loginbtn.setTypeface(bold);
        username_et.setTypeface(regular);
        userpassword_et.setTypeface(regular);
        username_il.setTypeface(regular);
        userpassword_il.setTypeface(regular);

    }


    public Boolean validatesignup() {

        if (username_et.getText().toString().length() < 1) {
            username_il.setError("Enter User Name");
            username_il.setErrorEnabled(true);
            return false;

        } else if (userpassword_et.getText().toString().length() < 1) {
            userpassword_il.setError("Enter Password");
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

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.signup_signupBtn:


                if (validatesignup()) {

                    Log.e("validatesignup", username + "\t" + password);

                }
                break;

            case R.id.signup_loginbtn:

                /*Intent signup = new Intent(SignUp.this, LoginActivity.class);
                startActivity(signup);*/
                finish();

                break;

        }
    }
}
