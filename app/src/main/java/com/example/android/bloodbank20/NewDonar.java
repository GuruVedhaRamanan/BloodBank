package com.example.android.bloodbank20;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class NewDonar extends AppCompatActivity {

    EditText name, RollNumber, PhoneNumber, Address;
    Spinner fields;

    Button savebutn;
    ProgressDialog progressDialog;


    public static String person,genres,Roll,phone,address;

    DatabaseReference data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_donar);

        data = FirebaseDatabase.getInstance().getReference("User Details");

        name = (EditText) findViewById(R.id.username);

        RollNumber = (EditText) findViewById(R.id.RollNumber);

        fields = (Spinner) findViewById(R.id.fields);
        progressDialog = new ProgressDialog(this);

        PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);

        Address = (EditText) findViewById(R.id.Address);




        savebutn = (Button) findViewById(R.id.savebutton);


        savebutn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)

            {


                Addperson();
                name.setText("");

                RollNumber.setText("");

                PhoneNumber.setText("");

                Address.setText("");


            }
        });

    }
    public void Addperson() {
        person = name.getText().toString().trim();

        genres = fields.getSelectedItem().toString();

        Roll = RollNumber.getText().toString();

        phone = PhoneNumber.getText().toString();

        address = Address.getText().toString();

progressDialog.setMessage("saving your details");
        progressDialog.show();

        if(Objects.equals(person, "a")||(Objects.equals(person,"b"))||Objects.equals(person,"c")||Objects.equals(person,"d")||Objects.equals(person,"I")||Objects.equals(person,"i"))
        {
            Toast.makeText(NewDonar.this, "Enter the Data Properly", Toast.LENGTH_LONG).show();

            return;

        }


        if (!TextUtils.isEmpty(person) && !TextUtils.isEmpty(genres) && !TextUtils.isEmpty(Roll) && !TextUtils.isEmpty(phone)) {

            UserInformation userInformation = new UserInformation(Roll, person, genres, phone, address);

            data.child(userInformation.getUserId()).setValue(userInformation, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError == null) {
                        progressDialog.dismiss();
                        Toast.makeText(NewDonar.this, "Thank You For Your Contribution ", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(NewDonar.this, " Check Your Internet Connection and try again ", Toast.LENGTH_LONG).show();

                    }
                }
            });


        } else

        {
            progressDialog.dismiss();
            Toast.makeText(NewDonar.this, "Fill up all the Details", Toast.LENGTH_LONG).show();
        }
    }

}

