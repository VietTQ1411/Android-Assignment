package com.example.library.Entity;

public class UserModel {
    private int id;
    private String userName;
    private String tokenKey;
    private boolean isLogging;

    public UserModel(int id, String userName, String tokenKey, boolean isLogging) {
        this.id = id;
        this.userName = userName;
        this.tokenKey = tokenKey;
        this.isLogging = isLogging;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public boolean isLogging() {
        return isLogging;
    }

    public void setLogging(boolean logging) {
        isLogging = logging;
    }
}
