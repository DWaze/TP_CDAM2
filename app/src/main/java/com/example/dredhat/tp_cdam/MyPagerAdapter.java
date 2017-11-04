package com.example.dredhat.tp_cdam;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by lhadj on 10/22/2017.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private Context ctx;
    public MyPagerAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        this.ctx = ctx;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            default:
                return new FirstFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return ctx.getString(R.string.firstTitle);
            case 1: return ctx.getString(R.string.secondTitle);
            default:return  ctx.getString(R.string.firstTitle);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
