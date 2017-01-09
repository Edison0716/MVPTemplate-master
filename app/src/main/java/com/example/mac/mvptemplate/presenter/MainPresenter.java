package com.example.mac.mvptemplate.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.mac.mvptemplate.ui.fragment.FavoriteFragment;
import com.example.mac.mvptemplate.ui.view.IMainView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 17/1/9.
 */

public class MainPresenter {
    private Context mContext;
    private IMainView mainView;
    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<>();

    public MainPresenter(Context mContext, IMainView mainView) {
        this.mContext = mContext;
        this.mainView = mainView;
    }

    public void init() {
        //向fragment容器中添加fragment
        FragmentManager manager = mainView.getManager();
        fragmentList.add(new FavoriteFragment());
        fragmentList.add(new FavoriteFragment());
        fragmentList.add(new FavoriteFragment());
        fragmentList.add(new FavoriteFragment());
        viewPager = mainView.getViewPager();//获取viewpager
        /**
        * 为viewpager设置适配器
        * */
        viewPager.setAdapter(new FragmentStatePagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        /**
        * 将底部菜单与viewpager进行绑定
        * */
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 mainView.setSelectPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    /**
    * 设置当前选中的tab
    * */
    public void setCurrentTab(int position){
        viewPager.setCurrentItem(position);
    }
}
