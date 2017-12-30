package com.example.android.bloodbank20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class PasswordActivity extends AppCompatActivity {
    public static String mypassword = "";


    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);


        password = (EditText) findViewById(R.id.Password);

    }

    public void next(View view) {
        String passwords = password.getText().toString();
        if (TextUtils.isEmpty(mypassword)) {
            if (Objects.equals(passwords, "venu")) {
                Intent intent = new Intent(this, NeedDonar.class);
                finish();
                startActivity(intent);

            } else {
                Toast.makeText(this, "Enter the password correctly", Toast.LENGTH_LONG).show();
            }
        }
        else if(Objects.equals(passwords,PasswordActivity.mypassword))
        {
            Intent intent = new Intent(this, NeedDonar.class);
            finish();
            startActivity(intent);

        }


    }

}