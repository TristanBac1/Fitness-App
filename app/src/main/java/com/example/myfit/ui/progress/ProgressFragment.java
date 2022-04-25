package com.example.myfit.ui.progress;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myfit.Adapter.SectionPagerAdapter;
import com.example.myfit.R;
import com.example.myfit.databinding.FragmentProgressBinding;
import com.example.myfit.ui.diary.DiaryFragment;
import com.example.myfit.ui.food.FoodFragment;
import com.example.myfit.ui.gym.GymFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class ProgressFragment extends Fragment {

    View myFragment;
    ViewPager2 viewPager;
    TabLayout tabLayout;

    private ProgressViewModel progressViewModel;
    private Context context;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_progress, container, false);

        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabLayout);

        setUpViewPager(viewPager);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        tabLayout.addTab(tabLayout.newTab().setText("Diary"));
        tabLayout.addTab(tabLayout.newTab().setText("Gym"));
        tabLayout.addTab(tabLayout.newTab().setText("Food"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return myFragment;
    }

    private void setUpViewPager(ViewPager2 viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getActivity().getSupportFragmentManager());

        adapter.addFragment(new DiaryFragment(), "Diary");
        adapter.addFragment(new GymFragment(), "Gym");
        adapter.addFragment(new FoodFragment(), "Food");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        com.example.myfit.databinding.FragmentProgressBinding binding = null;
    }
}
