package com.example.android.concisnews.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.android.concisnews.Adapters.PagerFragmentAdapter;
import com.example.android.concisnews.R;

public class MainActivity extends AppCompatActivity {
FragmentPagerAdapter adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vpPager = findViewById(R.id.vpPager);
        adapterViewPager = new PagerFragmentAdapter(getSupportFragmentManager(),0);
        vpPager.setAdapter(adapterViewPager);

        vpPager.setCurrentItem(1);
    }
}