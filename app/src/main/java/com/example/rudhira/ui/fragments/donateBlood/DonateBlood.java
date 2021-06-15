package com.example.rudhira.ui.fragments.donateBlood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.android.loginscreen.R;


public class DonateBlood extends Fragment implements View.OnClickListener{

    private DonateBloodViewModel mViewModel;

    public static DonateBlood newInstance() {
        return new DonateBlood();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.donate_blood_fragment, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DonateBloodViewModel.class);
        // TODO: Use the ViewModel

    }

    @Override
    public void onClick(View v) {

    }
}