package com.example.myfit.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myfit.ui.diary.DiaryFragment;
import com.example.myfit.ui.food.FoodFragment;
import com.example.myfit.ui.gym.GymFragment;

import java.util.ArrayList;
import java.util.List;

public class SectionPagerAdapter extends FragmentStateAdapter
{
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm.getPrimaryNavigationFragment());
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0 ) {
            return new DiaryFragment();
        }
        if (position == 2 ) {
            return new GymFragment();
        }
        else {
            return new FoodFragment();
        }
    }

    public void addFragment(Fragment fragment, String title) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }


}
