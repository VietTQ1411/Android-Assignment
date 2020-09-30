package com.example.library.Resources;

import android.app.Application;
import android.content.res.Resources;

public class App extends Application {
    private static App mInstance;
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