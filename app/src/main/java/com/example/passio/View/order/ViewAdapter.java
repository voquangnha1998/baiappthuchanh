package com.example.passio.View.order;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewAdapter extends FragmentStatePagerAdapter {

    public ViewAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new BanChayFragment();
            case 1:
                return new BanChayFragment();
            case 2:
                return new BanChayFragment();
            case 3:
                return new BanChayFragment();
            case 4:
                return new BanChayFragment();
            default:
                return  new BanChayFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){

            case 0:
                title ="Bán chạy   ";
                break;
            case 1:
                title ="Món mới    ";
                break;
            case 2:
                title ="Tất cả     ";
                break;
            case 3:
                title ="Tea/soda   ";
                break;
            case 4:
                title ="Passio coffee";
                break;
        }
        return title;
    }
}