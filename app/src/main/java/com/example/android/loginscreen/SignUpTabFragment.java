package com.example.android.loginscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpTabFragment extends Fragment
{
    EditText email, mobile, pass, confirm;
    Button signUpButton;
    float v=0;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        email = root.findViewById(R.id.emailSignUp);
        mobile = root.findViewById(R.id.mobileNum);
        pass = root.findViewById(R.id.password);
        confirm = root.findViewById(R.id.confirmPassword);
        signUpButton = root.findViewById(R.id.signUpButton);

        email.setTranslationX(800);
        mobile.setTranslationX(800);
        pass.setTranslationX(800);
        confirm.setTranslationX(800);
        signUpButton.setTranslationX(800);

        email.setAlpha(v);
        mobile.setAlpha(v);
        pass.setAlpha(v);
        confirm.setAlpha(v);
        signUpButton.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        mobile.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        confirm.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        signUpButton.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();  // gets the rootNode that contains al the data
                reference = rootNode.getReference("users");

                reference.setValue("First Data Storage");
            }
        });



        return root;
    }
}
