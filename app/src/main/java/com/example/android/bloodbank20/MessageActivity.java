package com.example.android.bloodbank20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

    public class MessageActivity extends AppCompatActivity {



    EditText name, bloodgroup, phonenumber, hospital;

    Button send;



    ArrayList<UserEmergency> arrayList;
    private DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);



        name = (EditText) findViewById(R.id.name);

        bloodgroup = (EditText) findViewById(R.id.blood);

        phonenumber = (EditText) findViewById(R.id.contactnumber);

        hospital = (EditText) findViewById(R.id.hospital);

        send = (Button) findViewById(R.id.sendss);

        arrayList = new ArrayList<UserEmergency>();

        ref = FirebaseDatabase.getInstance().getReference("Emergency");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SentEmergencyMessage();
            }
        });
    }

    public void SentEmergencyMessage() {
        String username = name.getText().toString();

        String bloodgroups = bloodgroup.getText().toString();


        String phonenumbers = phonenumber.getText().toString();


        String hospitals = hospital.getText().toString();

        name.setText("");

        bloodgroup.setText("");

        phonenumber.setText("");

        hospital.setText("");

        if(Objects.equals(username, "a") || Objects.equals(username, "b") || Objects.equals(username, "c") ||
                Objects.equals(username, "d") || Objects.equals(username, "e") || Objects.equals(username, "f") ||
                Objects.equals(username, "g") || Objects.equals(username, "h") || Objects.equals(username, "i") || Objects.equals(username, "j") || Objects.equals(username, "k") || Objects.equals(username, "I"))
        {
            Toast.makeText(MessageActivity.this, "Enter the Data Properly", Toast.LENGTH_LONG).show();
            return;
        }

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(bloodgroups) && !TextUtils.isEmpty(phonenumbers) && !TextUtils.isEmpty(hospitals))
        {
            UserEmergency userEmergency = new UserEmergency(username, bloodgroups, phonenumbers, hospitals);

            ref.child(userEmergency.getPhonenumber()).setValue(userEmergency, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError == null) {
                        Toast.makeText(MessageActivity.this, "We saved Your Message,We will reach you Soon", Toast.LENGTH_LONG).show();
                    } else
                    {
                        Toast.makeText(MessageActivity.this, " Check Your Internet Connection and try again ", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(this, "Fill Up all the Details", Toast.LENGTH_SHORT).show();
        }
    }
     public void messagesshow(View view)
     {
         Intent intent = new Intent(this,EmergerncyMessages.class);

         startActivity(intent);
     }

}
