package com.example.android.bloodbank20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Newpassword extends AppCompatActivity {

    String newpassword;

    EditText newpasswords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);

        newpasswords = (EditText)findViewById(R.id.newPassword);



    }
   public void updates(View view)
   {
       newpassword = newpasswords.getText().toString();

       PasswordActivity.mypassword = newpassword;

         Toast.makeText(this,"Your password is updated Successfully",Toast.LENGTH_LONG).show();
   }

}
