package com.example.android.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpTabFragment extends Fragment
{
    EditText email, mobile, pass, confirm;
    Button signUpButton;
    float v=0;

    FirebaseAuth fAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        email = root.findViewById(R.id.emailSignUp);
        mobile = root.findViewById(R.id.mobileNum);
        pass = root.findViewById(R.id.password);
        confirm = root.findViewById(R.id.confirmPassword);
        signUpButton = root.findViewById(R.id.signUpButton);
        fAuth = FirebaseAuth.getInstance();

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

        if(fAuth.getCurrentUser()!=null) // if already logged in
        {
            startActivity(new Intent(getActivity(), MainActivity.class));
        }

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myEmail = email.getText().toString().trim();
                String myPass = pass.getText().toString().trim();

                if(TextUtils.isEmpty(myEmail)){
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(myPass)){
                    pass.setError("Password is required");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(myEmail, myPass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getActivity(), "User Created", Toast.LENGTH_SHORT).show();
                                     startActivity(new Intent(getActivity(), MainActivity.class));
                                }
                                else {
                                    Toast.makeText(getActivity(), "Try again" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });



        return root;
    }
}
