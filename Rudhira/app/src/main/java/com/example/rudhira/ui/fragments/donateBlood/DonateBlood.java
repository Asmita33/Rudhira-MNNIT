package com.example.rudhira.ui.fragments.donateBlood;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.ClipData;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.rudhira.R;
import com.example.rudhira.ui.fragments.donateBlood.donateBloodFragments.UserDocuments;
import com.example.rudhira.ui.fragments.donateBlood.donateBloodFragments.UserInfo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DonateBlood extends Fragment implements View.OnClickListener{

    private com.example.rudhira.ui.fragments.donateBlood.DonateBloodViewModel mViewModel;

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
        mViewModel = ViewModelProviders.of(this).get(com.example.rudhira.ui.fragments.donateBlood.DonateBloodViewModel.class);
        // TODO: Use the ViewModel

    }

    @Override
    public void onClick(View v) {

    }
}