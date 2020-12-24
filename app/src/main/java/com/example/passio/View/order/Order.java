package com.example.passio.View.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.passio.R;
import com.google.android.material.tabs.TabLayout;

public class Order extends AppCompatActivity {

    TabLayout mTapLayout;
    ViewPager mViewPager;
    ImageButton imageButton;
    TextView gia4,somon4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mTapLayout = findViewById(R.id.tab_layout1);
        mViewPager = findViewById(R.id.viewpager1);
        imageButton = findViewById(R.id.btnback);

        ViewAdapter viewPagerAdapter= new ViewAdapter(Order.this.getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);
        mTapLayout.setupWithViewPager(mViewPager);

//        somon4 = findViewById(R.id.somon4);
//        gia4 = findViewById(R.id.gia4);


//        int a =0;
//        int somon = 0;
//
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        int sl = preferences.getInt("soluong",0);
//        int tg = preferences.getInt("thanhgia",0);
//
//        int s= somon+sl;
//        int x = a+tg;
//        somon4.setText(s+"");
//        gia4.setText(x+"");


    }
}