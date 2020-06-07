package com.nagraj.sqlbrightchatbot;

public class Profile {
    private String name;
    private String mobileNo;
    private int id;
    private  boolean gender;


    public Profile(String name, String mobileNo, int id, boolean gender) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.id = id;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


}
