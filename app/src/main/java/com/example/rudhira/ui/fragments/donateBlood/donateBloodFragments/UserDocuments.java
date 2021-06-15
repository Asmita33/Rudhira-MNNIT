package com.example.rudhira.ui.fragments.donateBlood.donateBloodFragments;
import com.example.android.loginscreen.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

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
        UserDocumentsViewModel mViewModel = ViewModelProviders.of(this).get(UserDocumentsViewModel.class);
        // TODO: Use the ViewModel
    }

}