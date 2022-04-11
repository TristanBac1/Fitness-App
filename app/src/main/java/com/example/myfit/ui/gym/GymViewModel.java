package com.example.myfit.ui.gym;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GymViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GymViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gym fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}