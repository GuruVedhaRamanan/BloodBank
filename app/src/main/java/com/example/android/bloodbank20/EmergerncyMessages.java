package com.example.android.bloodbank20;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.android.bloodbank20.R.id.emergency;

public class EmergerncyMessages extends AppCompatActivity {

    ListView MessageList;

    ArrayList<UserEmergency> arrayList;

    TextView text;

    private DatabaseReference refs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergerncy_messages);

        text =(TextView)findViewById(R.id.noemergency);


        MessageList = (ListView) findViewById(emergency);

        arrayList = new ArrayList<>();

        refs = FirebaseDatabase.getInstance().getReference("Emergency");
        MessageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserEmergency userEmergency = arrayList.get(position);
                String phone = userEmergency.getPhonenumber();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });
        MessageList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

               UserEmergency user = arrayList.get(position);

                ShowDialog(user.getPhonenumber());
                return false;
            }
        });

    }
    public void onStart() {
        super.onStart();
        if (arrayList.isEmpty()) {
            text.setVisibility(View.VISIBLE);
        }
        refs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                arrayList.clear();
                for (DataSnapshot usersnapshot : dataSnapshot.getChildren()) {
                    UserEmergency user = usersnapshot.getValue(UserEmergency.class);
                    arrayList.add(user);
                    text.setVisibility(View.INVISIBLE);
                }
                EmergencyAdapter adapter = new EmergencyAdapter(EmergerncyMessages.this, arrayList);
                MessageList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



   public void ShowDialog(final String userphonenumber)
   {
       AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(this);

       LayoutInflater inflater = getLayoutInflater();

       View dialogview = inflater.inflate(R.layout.deletelayout,null);

       dialogbuilder.setView(dialogview);
       dialogbuilder.setTitle("Deleting the Messages of"+userphonenumber);

       final AlertDialog alertDialog = dialogbuilder.create();

       alertDialog.show();

       final Button butn = (Button)dialogview.findViewById(R.id.button3);


       butn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                delete(userphonenumber);

               alertDialog.dismiss();


           }
       });
   }

    private void delete(String userphonenumber) {

        DatabaseReference data = FirebaseDatabase.getInstance().getReference("Emergency").child(userphonenumber);

         data.removeValue();


    }


}
