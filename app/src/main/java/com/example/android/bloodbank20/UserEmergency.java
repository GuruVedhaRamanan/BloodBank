package com.example.android.bloodbank20;

/**
 * Created by MY PC on 17-12-2017.
 */

public class UserEmergency {
    public   String name;

    public  String bloodgroup;

    public   String phonenumber;

    public   String hospital;



    public UserEmergency(String name, String bloodgroup, String phonenumber, String hospital) {
        this.name = name;
        this.bloodgroup = bloodgroup;
        this.phonenumber = phonenumber;
        this.hospital = hospital;
    }

    public String getName() {
        return name;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getHospital() {
        return hospital;
    }



    public UserEmergency() {
    }
}

