package com.example.android.bloodbank20;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserList extends ArrayAdapter<UserInformation>{
    private Activity context;

  private  List<UserInformation> userList;

    public UserList(Activity context, List<UserInformation> userList) {
        super(context, R.layout.listlayout, userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View view = inflater.inflate(R.layout.listlayout, null, true);

        TextView Name = (TextView) view.findViewById(R.id.Name);

        TextView textViewGenre = (TextView) view.findViewById(R.id.Fields);

        TextView textViewPhone = (TextView) view.findViewById(R.id.PhoneNumber);

        TextView textViewAddress = (TextView)view.findViewById(R.id.location);

        UserInformation userInformation = userList.get(position);

        Name.setText(userInformation.getUserName());

        textViewGenre.setText(userInformation.getUserField());

        textViewPhone.setText("\t\t"+userInformation.getPhoneNumber());

        textViewAddress.setText("\t\t"+userInformation.getAddress());


        return view;

    }



}


