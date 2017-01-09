package com.example.mac.mvptemplate.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.example.mac.mvptemplate.R;
import com.example.mac.mvptemplate.presenter.MainPresenter;
import com.example.mac.mvptemplate.ui.view.IMainView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainView{

    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private MainPresenter presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    @Override
    void init() {
        presenter = new MainPresenter(this,this);
        presenter.init();
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_favorites:
                        presenter.setCurrentTab(0);
                        break;
                    case R.id.tab_nearby:
                        presenter.setCurrentTab(1);
                        break;
                    case R.id.tab_friends:
                        presenter.setCurrentTab(2);
                        break;
                    case R.id.tab_setting:
                        presenter.setCurrentTab(3);
                        break;
                }
            }
        });
    }
    @Override
    public ViewPager getViewPager() {
        return viewPager;
    }

    @Override
    public FragmentManager getManager() {
        return getSupportFragmentManager();
    }

    @Override
    public void setSelectPosition(int position) {
        bottomBar.selectTabAtPosition(position);
    }


}
