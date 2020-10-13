package com.example.library.Common.Helper;

import com.example.library.Data.Entity.BookModel;
import com.example.library.Data.Entity.UserModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Function hỗ trợ chung
 */
public class CommonUtils {
    /**
     * Convert an object JSon to Book model
     * @param object JSONObject
     * @return book model or null if error
     */
    @Nullable
    public static BookModel convertFromJSonToBookObject(@NotNull JSONObject object) {
        try {
            return BookModel.builder()
                    .id(object.getInt("id"))
                    .imageUrl(object.getString("imageUrl"))
                    .name(object.getString("name"))
                    .author(object.getString("author"))
                    .rate(object.getInt("rate"))
                    .description(object.getString("description"))
                    .build();
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * Convert an object JSon to User model
     * @param object JSONObject
     * @return user model or null if error
     */
    @Nullable
    public static UserModel convertFromJSonToUserObject(@NotNull JSONObject object) {
        try {
            return UserModel.builder()
                    .id(object.getInt("id"))
                    .email(object.getString("email"))
                    .name(object.getString("name"))
                    .tokenKey(object.getString("tokenKey"))
                    .phoneNumber(object.getString("phoneNumber"))
                    .expiredDate(convertStringToDate(object.getString("expiredDate")))
                    .userType(object.getString("userType"))
                    .build();
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * Convert date time string to Date type
     * @param date String
     * @return date time convert
     */
    public static Date convertStringToDate(String date){
        return Date.from(Instant.from(DateTimeFormatter.ISO_INSTANT.parse(date)));
    }
}
