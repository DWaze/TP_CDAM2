package com.example.dredhat.tp_cdam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class ForgotPassword extends AppCompatActivity implements Validator.ValidationListener {

    @Email
    EditText email;

    EditText digitsConfirm;
    String digits;
    Button btnConfirm;
    int verificationStep;

    TextView hints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.rEmail);
        digitsConfirm = findViewById(R.id.digitVerif);
        btnConfirm = findViewById(R.id.rConfirm);
        hints = findViewById(R.id.hints);

        digitsConfirm.setClickable(false);
        verificationStep = 1;
        digits = 1234 + "";

        final Validator validator = new Validator(this);
        validator.setValidationListener(this);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificationStep == 1) {
                    validator.validate();
                } else {
                    if (digits.equals(digitsConfirm.getText().toString())) {
                        hints.setText(R.string.digits_check_2);
                    } else {
                        Toast.makeText(ForgotPassword.this, R.string.digits_check_error, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    @Override
    public void onValidationSucceeded() {

        // verifying email
        verificationStep = 2;
        hints.setText(R.string.digits_check);
        digitsConfirm.setClickable(true);
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
