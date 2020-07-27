package com.example.creationgallery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class homepage extends AppCompatActivity {
    private TabLayout tablayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        tablayout= (TabLayout)findViewById(R.id.tablayout);
        appBarLayout= (AppBarLayout)findViewById(R.id.appbarid);
        viewPager= (ViewPager)findViewById(R.id.viewpager);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        // Adding Fragments
        adapter.AddFragment(new photo(),"Photo");
        adapter.AddFragment(new video(),"Video");
        adapter.AddFragment(new recent(),"Saved");
        //adapter setup
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);
    }
}
