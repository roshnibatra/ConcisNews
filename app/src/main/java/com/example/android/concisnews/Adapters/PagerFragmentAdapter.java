package com.example.android.concisnews.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android.concisnews.fragments.CategoryFragment;
import com.example.android.concisnews.fragments.NewsFragment;
import com.example.android.concisnews.fragments.NewsWebView;

public class PagerFragmentAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

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
                return NewsWebView.newInstance();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
