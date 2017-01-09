package com.example.mac.mvptemplate.presenter;

import android.content.Context;

import com.example.mac.mvptemplate.ui.view.ILoginView;
import com.example.mac.mvptemplate.utils.PrefUtils;

/**
 * Created by mac on 2017/1/8.
 */

public class LogInPresenter {

    private Context mContext;
    private ILoginView loginView;

    public LogInPresenter(Context mContext, ILoginView loginView) {
        this.mContext = mContext;
        this.loginView = loginView;
    }

    public void login() {
        String userName = loginView.getUserName();
        String userPwd = loginView.getUserPwd();
        if (userName.equals("18644056528") && userPwd.equals("123456")) {
            loginView.loginSuccess();
            PrefUtils.putBoolean("isLogged",true,mContext);
        } else {
            loginView.loginError();
        }
    }
}
