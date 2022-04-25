package com.example.myfit.ui.log;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myfit.Adapter.SectionPagerAdapter;
import com.example.myfit.R;
import com.example.myfit.databinding.FragmentLogBinding;
import com.example.myfit.ui.diary.DiaryFragment;
import com.example.myfit.ui.food.FoodFragment;
import com.example.myfit.ui.gym.GymFragment;
import com.google.android.material.tabs.TabLayout;

public class LogFragment extends Fragment {

    View logFragment;
    ViewPager2 logViewPager;
    TabLayout logTabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        logViewModel =
//                new ViewModelProvider(this).get(LogViewModel.class);
//
//        binding = FragmentLogBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textLog;
//
//        logViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
        logFragment = inflater.inflate(R.layout.fragment_log, container, false);
        logViewPager = logFragment.findViewById(R.id.logViewPager);
        logTabLayout = logFragment.findViewById(R.id.logTabLayout);

        setUpViewPager(logViewPager);
        logViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                logTabLayout.selectTab(logTabLayout.getTabAt(position));
            }
        });

        logTabLayout.addTab(logTabLayout.newTab().setText("Gym"));
        logTabLayout.addTab(logTabLayout.newTab().setText("Food"));
        logTabLayout.addTab(logTabLayout.newTab().setText("Activity"));

        logTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                logViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return logFragment;
    }

    private void setUpViewPager(ViewPager2 viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getActivity().getSupportFragmentManager());

        adapter.addFragment(new DiaryFragment(), "Gym");
        adapter.addFragment(new GymFragment(), "Food");
        adapter.addFragment(new FoodFragment(), "Activity");

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        com.example.myfit.databinding.FragmentLogBinding binding = null;
    }
}
