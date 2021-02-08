package com.example.android.concisnews.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android.concisnews.fragments.CategoryFragment;
import com.example.android.concisnews.fragments.NewsFragment;
import com.example.android.concisnews.fragments.ProfileFragment;
import com.example.android.concisnews.fragments.filter_fragment;

public class PagerFragmentAdapter extends FragmentPagerAdapter {

    public PagerFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return CategoryFragment.newInstance();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return NewsFragment.newInstance();
            case 2: // Fragment # 0 - This will show FirstFragment different title
                return ProfileFragment.newInstance();
            case 3: // Fragment # 0 - This will show FirstFragment different title
                return filter_fragment.newInstance();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        int NUM_ITEMS = 4;
        return NUM_ITEMS;
    }
}
