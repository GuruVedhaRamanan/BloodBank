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

public class Apositive extends AppCompatActivity {
    ListView lists;

    TextView alert;

    ArrayList<UserInformation> arrayList;

    private ProgressDialog progressDialog;
    DatabaseReference data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apositive);
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
                progressDialog.dismiss();
                for (DataSnapshot usersnapshot : dataSnapshot.getChildren()) {
                    UserInformation user = usersnapshot.getValue(UserInformation.class);
                    if(user.getUserField().equals("A+ve")) {
                        alert.setVisibility(View.INVISIBLE);
                        arrayList.add(user);
                        Collections.sort(arrayList,UserInformation.UserNameComparator);
                    }
                }

                UserList adapter = new UserList(Apositive.this, arrayList);
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




