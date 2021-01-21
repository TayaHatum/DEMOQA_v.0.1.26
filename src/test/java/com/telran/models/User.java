package com.telran.models;

public class User {
    private String fName;
    private String lName;
    private String userName;
    private String password;

    public User withfName(String fName) {
        this.fName = fName;
        return this;
    }

    public User withlName(String lName) {
        this.lName = lName;
        return this;
    }

    public User withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
