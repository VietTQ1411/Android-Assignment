package com.example.library.Data.RespositoriesAPI.Repositories;

import android.util.Log;

import com.example.library.AppResources;
import com.example.library.Common.Helper.CommonUtils;
import com.example.library.Data.Entity.UserModel;
import com.example.library.Data.RespositoriesAPI.IRespository.IUserRespository;
import com.example.library.R;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Singleton class user call API and get user data from server
 * Class thao tác và lấy dữ liệu của User
 */
public class UserRepository {
    private static UserRepository instance = null;
    private IUserRespository iUserRespository;
    private static String TAG = "UserRepository";

    /**
     * Constructor
     *
     * @param iUserRespository interface execute call API
     */
    private UserRepository(IUserRespository iUserRespository) {
        this.iUserRespository = iUserRespository;
    }

    /**
     * String URL API USER
     */
    public static final String URL_LOGIN_USER =
            "http://" + AppResources.getResourses().getString(R.string.HOST_NAME) + ":"
                    + AppResources.getResourses().getString(R.string.PORT) + "/"
                    + AppResources.getResourses().getString(R.string.USER_LOGIN);

    public static UserRepository getInstance(IUserRespository iUserRespository) {
        if (instance == null) {
            instance = new UserRepository(iUserRespository);
        }
        return instance;
    }

    /**
     * Login to server
     */
    public void login(String name, String password) {
        OkHttpClient okHttpClient = new OkHttpClient();

        //Prepare
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", name )
                .addFormDataPart("password", password )
                .build();
        Request request = new Request.Builder()
                .url(URL_LOGIN_USER)
                .post(requestBody)
                .build();

        /* Execute */
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    String jsonString = response.body().string();
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONObject jsonUserObject = jsonObject.getJSONObject("data");
                    UserModel userModel = CommonUtils.convertFromJSonToUserObject(jsonUserObject);

                    iUserRespository.afterLogin(userModel, null);
                } catch (JSONException ex) {
                    iUserRespository.afterLogin(null, ex);
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "that bai");
                iUserRespository.afterLogin(null, e);
            }
        });
    }
}
