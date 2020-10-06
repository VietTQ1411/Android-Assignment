package com.example.library.RespositoriesAPI;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.library.Entity.BookModel;
import com.example.library.R;
import com.example.library.Resources.App;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
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
    private List<BookModel> listUser;
    private static  String TAG = "BookRepository";
    private BookRepository(){}
    public static final String URL_GET_BOOKS =
            "http://"+ App.getInstance().getResourses().getString(R.string.HOST_NAME)+":"+App.getInstance().getResourses().getString(R.string.PORT)+"/books";

    public static BookRepository getInstance(){
        if(instance==null){
            instance = new BookRepository();
        }
        return instance;
    }
    public MutableLiveData<List<BookModel>> getBooks(){
        MutableLiveData<List<BookModel>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(null);
        return mutableLiveData;
    }
    public void getBooksFromServer() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_GET_BOOKS)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "thanh cong");
            }
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "that bai");
            }
        });
    }
}
