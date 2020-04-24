package com.example.viewpagernavigation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    Fragment[] pages;
    public PageAdapter(FragmentManager fm, Fragment[] pages) {
        super(fm);
        this.pages = pages;

    }

    @Override
    public Fragment getItem(int position) {
        return pages[position];
    }

    @Override
    public int getCount() {
        return pages.length;
    }
}
