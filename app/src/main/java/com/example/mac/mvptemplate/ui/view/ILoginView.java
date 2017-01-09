package com.example.mac.mvptemplate.ui.view;

/**
 * Created by mac on 2017/1/7.
 */

public interface ILoginView {
    String getUserName();
    String getUserPwd();

    void loginSuccess();
    void loginError();
}
