package com.example.android.bloodbank20;

import java.util.Comparator;

public  class UserInformation  {

        String userId;

        String userName;

        String userField;

        String phoneNumber;

        String address;

        String message;

    public UserInformation(String userId, String userName, String userField, String phoneNumber,String address) {
        this.userId = userId;
        this.userName = userName;
        this.userField = userField;
        this.phoneNumber = phoneNumber;
        this.address =address;

    }

    public UserInformation() {
    }


    public String getAddress() {
        return address;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserField() {
        return userField;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


   public static Comparator<UserInformation> UserNameComparator = new Comparator<UserInformation>() {
       @Override
       public int compare(UserInformation userInformation1, UserInformation userInformation2) {

           String StudentName1 = userInformation1.getUserName().toUpperCase();
           String StudentName2 = userInformation2.getUserName().toUpperCase();

           //ascending order
           return StudentName1.compareTo(StudentName2);
       }
   };
}


