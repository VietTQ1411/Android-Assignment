package com.example.library.Common.Helper;

import com.example.library.Data.Entity.BookModel;
import com.example.library.Data.Entity.UserModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Function hỗ trợ chung
 */
public class CommonUtils {
    /**
     * Convert an object JSon to Book model
     * @param object
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
     * @param object
     * @return user model or null if error
     */
    @Nullable
    public static UserModel convertFromJSonToUserObject(@NotNull JSONObject object) {
        try {
            return UserModel.builder()
                    .id(object.getInt("id"))
                    .build();
        } catch (JSONException e) {
            return null;
        }
    }
}
