package com.aditde.krishi.models;

import android.widget.RadioGroup;

public class Users {

    String profilePic, userName, email, password, userID, firstName, lastName;
    int type;

    // Constructor
    public Users(String profilePic, String userName, String email, String password, String userID, String firstName, String lastName, int type) {
        this.profilePic = profilePic;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    // Empty constructor
    public Users(){}

    // SignUp constructor
    public Users(String userName, String email, String password,int type){
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
