package com.example.dredhat.tp_cdam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContainerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.container_restaurants, container,false);
        ViewPager pagerVP = (ViewPager) rootView.findViewById(R.id.pagesVP);
        TabLayout slidingTL = (TabLayout) rootView.findViewById(R.id.slidingTL);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getActivity(), getChildFragmentManager());
        pagerVP.setAdapter(myPagerAdapter);
        slidingTL.setupWithViewPager(pagerVP);
        return rootView;
    }

}
