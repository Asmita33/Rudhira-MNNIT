package com.example.rudhira.ui.fragments.donateBlood.donateBloodFragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rudhira.R;

public class UserDocuments extends Fragment {

    public static UserDocuments newInstance() {
        return new UserDocuments();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_documents_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        com.example.rudhira.ui.fragments.donateBlood.donateBloodFragments.UserDocumentsViewModel mViewModel = ViewModelProviders.of(this).get(com.example.rudhira.ui.fragments.donateBlood.donateBloodFragments.UserDocumentsViewModel.class);
        // TODO: Use the ViewModel
    }

}