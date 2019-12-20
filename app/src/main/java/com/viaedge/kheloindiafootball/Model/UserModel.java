package com.viaedge.kheloindiafootball.Model;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("userid")
    private int userid;

    @SerializedName("usertype")
    private int usertype;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;


    public UserModel(int userid, int usertype, String firstname, String lastname) {
        this.userid = userid;
        this.usertype = usertype;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getUserid() {
        return userid;
    }

    public int getUsertype() {
        return usertype;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
