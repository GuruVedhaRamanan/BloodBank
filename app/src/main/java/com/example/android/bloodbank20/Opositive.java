package com.example.android.bloodbank20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class Opositive extends AppCompatActivity {
    ListView lists;

    DatabaseReference data;
    TextView alert;
    private ProgressDialog progressDialog;
    ArrayList<UserInformation> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opositive);

        lists = (ListView)findViewById(R.id.opositivelist);
        progressDialog = new ProgressDialog(this);
        alert  = (TextView)findViewById(R.id.nodonors);
        arrayList = new ArrayList<>();
        if(arrayList.isEmpty())
        {
            progressDialog.dismiss();
            alert.setVisibility(View.VISIBLE);
        }

        data = FirebaseDatabase.getInstance().getReference("User Details");
    }
    public void onStart() {
        super.onStart();

        progressDialog.setMessage("Receiving the data");
        progressDialog.show();
        data.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                  arrayList.clear();
                for (DataSnapshot usersnapshot : dataSnapshot.getChildren()) {
                    UserInformation user = usersnapshot.getValue(UserInformation.class);
                    if(user.getUserField().equals("O+ve")) {
                        progressDialog.dismiss();
                        alert.setVisibility(View.INVISIBLE);
                        Collections.sort(arrayList,UserInformation.UserNameComparator);
                        arrayList.add(user);
                    }
                }

                UserList adapter = new UserList(Opositive.this, arrayList);
                lists.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserInformation userInformation = arrayList.get(position);
                String phone = userInformation.getPhoneNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

    }

    }

