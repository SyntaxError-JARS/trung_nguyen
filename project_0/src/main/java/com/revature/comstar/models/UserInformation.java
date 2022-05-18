package com.revature.comstar.models;

public class UserInformation {

    private String fname;
    private String lname;
    private String uname;
    private String password;
    private String email;

    public UserInformation(String fname, String lname, String uname, String password, String email) {
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.password = password;
        this.email = email;
    }

    public UserInformation() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}