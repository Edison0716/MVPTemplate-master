package com.example.mac.mvptemplate.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.mvptemplate.R;
import com.example.mac.mvptemplate.presenter.LogInPresenter;
import com.example.mac.mvptemplate.ui.view.ILoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements ILoginView, View.OnClickListener {

    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.et_phoNum)
    EditText etPhoNum;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.activity_register)
    RelativeLayout activityRegister;

    private LogInPresenter presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    @Override
    void init() {
        login.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        presenter = new LogInPresenter(this,this);
    }

    @Override
    public String getUserName() {
        return etPhoNum.getText().toString();
    }

    @Override
    public String getUserPwd() {
        return etPwd.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "登录失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                presenter.login();
                break;
            case R.id.iv_close:
                finish();
                break;
        }
    }
}
