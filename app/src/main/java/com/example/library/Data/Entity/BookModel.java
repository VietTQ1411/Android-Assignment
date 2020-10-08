package com.example.library.Data.Entity;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookModel{
    /**
     *
     */
    private int id;

    /**
     *
     */
    @Builder.Default
    private String imageUrl = "";

    /**
     *
     */
    @Builder.Default
    private String name = "";

    /**
     *
     */
    @Builder.Default
    private String author = "";

    /**
     *
     */
    @Builder.Default
    private int rate = 0;

    /**
     *
     */
    @Builder.Default
    private String description = "";

}