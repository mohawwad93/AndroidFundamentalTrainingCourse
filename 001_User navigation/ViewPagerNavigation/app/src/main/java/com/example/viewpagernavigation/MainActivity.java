package com.example.viewpagernavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment[] pages = new Fragment[3];
        pages[0] = new BlueFragment();
        pages[1] = new RedFragment();
        pages[2] = new GreenFragment();

        ViewPager viewPager = findViewById(R.id.viewpager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), pages);
        viewPager.setAdapter(pageAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Blue");
        tabLayout.getTabAt(1).setText("Red");
        tabLayout.getTabAt(2).setText("Green");

    }


    public void onBtnClick(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
