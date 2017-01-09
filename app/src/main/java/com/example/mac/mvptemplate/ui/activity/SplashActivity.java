package com.example.mac.mvptemplate.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mac.mvptemplate.R;
import com.example.mac.mvptemplate.presenter.SplashPresenter;
import com.example.mac.mvptemplate.ui.view.ISplashView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements ISplashView {


    @BindView(R.id.ivSplash)
    ImageView ivSplash;
    private SplashPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        init();
    }

    @Override
    void init() {
        Glide.with(this).load(R.drawable.splash).into(ivSplash);
        presenter = new SplashPresenter(this, this);
        presenter.judgeLogged();
    }

    @Override
    public void enterHome() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void enterLogin() {
        Intent intent = new Intent();
        intent.setClass(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
