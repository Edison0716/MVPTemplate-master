package com.example.mac.mvptemplate.presenter;

import android.content.Context;

import com.example.mac.mvptemplate.ui.view.ISplashView;
import com.example.mac.mvptemplate.utils.PrefUtils;

/**
 * Created by mac on 2017/1/7.
 */

public class SplashPresenter {

    private ISplashView splashView;
    private Context mContext;

    public SplashPresenter(Context mContext, ISplashView splashView) {
        this.mContext = mContext;
        this.splashView = splashView;
    }

    public void judgeLogged() {
        boolean isLogged = PrefUtils.getBoolean("isLogged", false, mContext);
        if (isLogged) {
            enterHome();
        } else {
            enterLogin();
        }
    }

    public void enterHome() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                splashView.enterHome();
            }
        }).start();
    }

    public void enterLogin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                splashView.enterLogin();
            }
        }).start();
    }
}
