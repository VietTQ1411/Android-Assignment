package com.example.library.Data.Entity;

import java.util.Date;

/**
 *
 */
public class UserModel {
    /**
     *
     */
    private int id;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String hashedPassword;

    /**
     *
     */
    private String tokenKey;

    /**
     *
     */
    private String phoneNumber;

    /**
     *
     */
    private Date expiredDate;

    /**
     *
     */
    private String userType;

    public UserModel(int id, String email, String name, String hashedPassword, String tokenKey,
                     String phoneNumber, Date expiredDate, String userType) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.hashedPassword = hashedPassword;
        this.tokenKey = tokenKey;
        this.phoneNumber = phoneNumber;
        this.expiredDate = expiredDate;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
