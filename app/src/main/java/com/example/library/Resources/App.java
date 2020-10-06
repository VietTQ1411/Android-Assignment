package com.example.library.Resources;

import android.app.Application;
import android.content.res.Resources;

/**
 *  Lấy ra Resources ở những package con không sử dụng trực tiếp được
 *  Get Resource form child package where can't call Resource directly
 */
public class App extends Application {
    //Singleton Object
    private static App mInstance;
    //Resources instance
    private static Resources res;


    private App(){
        res = getResources();
    }

    public static App getInstance() {
        if(mInstance == null){
            mInstance = new App();
        }
        return mInstance;
    }

    public static Resources getResourses() {
        return res;
    }

}