package com.example.library.Data.Entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * User Model
 */
@Data
@Builder
public class UserModel {
    /**
     *
     */
    @Builder.Default
    private int id = 0;

    /**
     *
     */
    @Builder.Default
    private String email = "";

    /**
     *
     */
    @Builder.Default
    private String name = "";

    /**
     *
     */
    @Builder.Default
    private String hashedPassword = "";

    /**
     *
     */
    @Builder.Default
    private String tokenKey = "";

    /**
     *
     */
    @Builder.Default
    private String phoneNumber = "";

    /**
     *
     */
    @Builder.Default
    private Date expiredDate = new Date();

    /**
     *
     */
    @Builder.Default
    private String userType = "";

}
