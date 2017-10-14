package com.example.dredhat.tp_cdam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class RegisterActivity extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty
    @Email
    EditText emailInput;
    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC_MIXED_CASE_SYMBOLS)
    EditText passwordInput;

    Button login,newAccount,forgetPassword;
    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.EmailInput);
        passwordInput = findViewById(R.id.PasswordInput);
        login = findViewById(R.id.Login);
        newAccount = findViewById(R.id.newAcount);
        forgetPassword = findViewById(R.id.fPassword);

        validator = new Validator(this);
        validator.setValidationListener(this);

        YoYo.with(Techniques.FadeIn)
                .duration(1000)
                .playOn(findViewById(R.id.LogoResto));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });
        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,NewAccount.class);
                startActivity(intent);
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onValidationSucceeded() {
        // Start a new activity
        MaterialDialog m=new MaterialDialog.Builder(this)
                .title("Login In")
                .content("Please wait ...")
                .progress(true, 0)
                .show();
//        Intent intent = new Intent(this,MainActivity.class);
//        startActivity(intent);
//        m.dismiss();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
