package com.example.management.dto;

public class CurrentUser {

    private String userName;
    private String password;
    private String role;

    public CurrentUser(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public CurrentUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
