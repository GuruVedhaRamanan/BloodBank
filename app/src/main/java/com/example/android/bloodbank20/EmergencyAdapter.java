package com.example.android.bloodbank20;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class EmergencyAdapter extends ArrayAdapter<UserEmergency> {

    private Activity context;

  private  List<UserEmergency> userEmergencylist;

    public EmergencyAdapter(Activity context, List<UserEmergency> userEmergencylist) {
        super(context, R.layout.emergencylayout, userEmergencylist);
        this.context = context;
        this.userEmergencylist = userEmergencylist;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View view = inflater.inflate(R.layout.emergencylayout, null, true);

        TextView Name = (TextView) view.findViewById(R.id.emergencymessage);

        TextView phonenumber =(TextView)view.findViewById(R.id.emergencynumber);

        UserEmergency userEmergency  = userEmergencylist.get(position);

        Name.setText(userEmergency.getName()+"\t"+"\t"+"needed"+"\t\t"+userEmergency.getBloodgroup()+"at"+"\t\t"+userEmergency.getHospital());

        phonenumber.setText(userEmergency.getPhonenumber());
        return view;

    }


}
