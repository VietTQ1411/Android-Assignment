package com.example.library.Data.RespositoriesAPI.IRespository;

import com.example.library.Data.Entity.UserModel;

public interface IUserRespository {
    void afterLogin(UserModel user , Exception ex);
    void afterRegister(UserModel user , Exception ex);
}
