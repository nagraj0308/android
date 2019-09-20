package com.nagraj.demomvp;

public class User {
    private String fullName = "";
    private String email = "";

    public User() {
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String newString() {
        return "Fullname : " + fullName + "\nEmail : " + email;
    }
}
