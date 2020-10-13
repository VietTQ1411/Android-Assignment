package com.example.library.Data.RespositoriesAPI.viewModel;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.library.Data.Entity.BookModel;
import com.example.library.Data.Entity.UserModel;
import com.example.library.Data.RespositoriesAPI.IRespository.IUserRespository;
import com.example.library.Data.RespositoriesAPI.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class LoginActivityViewModel extends ViewModel implements IUserRespository {
    private MutableLiveData<UserModel> liveData = new MutableLiveData<>();

    public LiveData<UserModel> getUser() {
        return liveData;
    }

    public void login(String user,String password){
        UserRepository.getInstance(this).login(user,password);
    }
    @Override
    public void afterLogin(final UserModel user, final Exception ex) {
        final LoginActivityViewModel that = this;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            //run on UI Thread
            @Override
            public void run() {
                that.liveData.setValue(ex == null ? user : UserModel.builder().build());
            }}
        );
    }

    @Override
    public void afterRegister(UserModel user, Exception ex) {

    }

//    @Override
//    public void getBooks(final List<BookModel> books, int pageNumber, final Exception error) {
//        final LoginActivityViewModel that = this;
//        new Handler(Looper.getMainLooper()).post(new Runnable() {
//            //run on UI Thread
//            @Override
//            public void run() {
//                that.liveData.setValue((error == null) ? books : new ArrayList<BookModel>());
//            }}
//        );
//    }
}
