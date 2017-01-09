package com.example.mac.mvptemplate.ui.view;


import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

/**
 * Created by mac on 17/1/9.
 */

public interface IMainView {

    ViewPager getViewPager();

    FragmentManager getManager();

    void setSelectPosition(int position);

}
