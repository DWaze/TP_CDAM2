package com.example.dredhat.tp_cdam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class NewAccount extends AppCompatActivity implements Validator.ValidationListener {

    Validator valid ;
    Button confirm;

    @Email
    EditText email;

    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC_MIXED_CASE_SYMBOLS)
    EditText password;

    @ConfirmPassword
    EditText cPassword;

    @NotEmpty
    EditText fName;

    @NotEmpty
    EditText lName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_acount);

        confirm = findViewById(R.id.confirm);
        email = findViewById(R.id.cEmail);
        password = findViewById(R.id.cPassword);
        cPassword = findViewById(R.id.ccPassword);
        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);

        valid = new Validator(this);
        valid.setValidationListener(this);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valid.validate();
            }
        });

    }

    @Override
    public void onValidationSucceeded() {
        new MaterialDialog.Builder(this)
                .title("Creating Account")
                .content("Please wait ...")
                .progress(true, 0)
                .show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
