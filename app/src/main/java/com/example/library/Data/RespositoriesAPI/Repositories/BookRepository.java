package com.example.library.Data.RespositoriesAPI.Repositories;

import android.util.Log;

import com.example.library.AppResources;

import com.example.library.Common.Helper.CommonUtils;
import com.example.library.Data.Entity.BookModel;
import com.example.library.Data.RespositoriesAPI.IRespository.IBookRespository;
import com.example.library.R;


import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Singleton class book call API and get books data from server
 * Class thao tác và lấy dữ liệu của books
 */
public class BookRepository {
    private static BookRepository instance = null;
    private IBookRespository iBookRespository;
    private List<BookModel> listBook = new ArrayList<>();
    private static String TAG = "BookRepository";

    private BookRepository(IBookRespository iBookRespository) {
        this.iBookRespository = iBookRespository;
    }

    public static final String URL_GET_BOOKS =
            "http://" + AppResources.getResourses().getString(R.string.HOST_NAME) + ":"
                    + AppResources.getResourses().getString(R.string.PORT) + "/books";

    public static BookRepository getInstance(IBookRespository iBookRespository) {
        if (instance == null) {
            instance = new BookRepository(iBookRespository);
        }
        return instance;
    }

    /**
     * Get API from server and parse to Object
     */
    public void getBooksFromServer() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_GET_BOOKS)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                try {
                    String jsonString = response.body().string();
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        BookModel book = CommonUtils.convertFromJSonToBookObject(object);
                        listBook.add(book);
                    }
                    iBookRespository.getBooks(listBook,0,null);
                } catch (JSONException ex) {
                    iBookRespository.getBooks(null,0,ex);
                }
            }
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "that bai");
                iBookRespository.getBooks(null,0,e);
            }
        });
    }
}
