package com.example.myfit.ui.gym;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myfit.databinding.FragmentGymBinding;

public class GymFragment extends Fragment {

    private GymViewModel gymViewModel;
    private FragmentGymBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gymViewModel =
                new ViewModelProvider(this).get(GymViewModel.class);

        binding = FragmentGymBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGym;
        gymViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}