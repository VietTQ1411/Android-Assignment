package com.example.library.Data.RespositoriesAPI;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.library.Data.Entity.BookModel;
import com.example.library.R;
import com.example.library.Common.Resources.App;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private List<BookModel> listBook;
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
                String jsonString = response.body().toString();
                try{
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    for (int i = 0; i< jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        BookModel book =  BookModel.convertFromJSonToObject(object);
                        listBook.add(book);
                    }
                }catch (JSONException ex){

                }
            }
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "that bai");
            }
        });
    }
}
