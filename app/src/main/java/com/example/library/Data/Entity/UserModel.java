package com.example.library.Data.Entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 *
 */
@Data
@Builder
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

}
