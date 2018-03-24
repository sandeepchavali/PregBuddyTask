package com.PregBuddyTask.activites;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.PregBuddyTask.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Typeface regular, bold;
    Button loginBtn, signupBtn;
    EditText username_et, userpassword_et;
    TextInputLayout username_il, userpassword_il;

    String username, password;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                if (validateLogin()) {

                    Log.e("validatesignup", username + "\t" + password);

                }
                break;

            case R.id.signupBtn:
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


}
