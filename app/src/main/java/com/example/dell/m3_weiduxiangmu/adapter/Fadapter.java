package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class Fadapter extends FragmentPagerAdapter
{

    private List<Fragment> flist;

    public Fadapter(FragmentManager fm, List<Fragment> flist) {
        super(fm);
        this.flist = flist;
    }

    @Override
    public Fragment getItem(int i) {
        return flist.get(i);
    }

    @Override
    public int getCount() {
        return flist.size();
    }
}
