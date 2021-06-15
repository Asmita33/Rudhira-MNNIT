package com.example.rudhira.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.android.loginscreen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginTabFragment extends Fragment
{
    EditText email, password;
    TextView forgot;
    Button login;
    float v=0;
    FirebaseAuth fAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.emailLogin);
        password = root.findViewById(R.id.passwordLogin);
        forgot = root.findViewById(R.id.forgotPassword);
        login = root.findViewById(R.id.loginbutton);
        fAuth = FirebaseAuth.getInstance();

        email.setTranslationX(800);
        password.setTranslationX(800);
        forgot.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        forgot.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        forgot.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();


        // validate the user input
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myEmail = email.getText().toString().trim();
                String myPass = password.getText().toString().trim();

                if(TextUtils.isEmpty(myEmail)){
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(myPass)){
                    password.setError("Password is required");
                    return;
                }

                // authenticate
                fAuth.signInWithEmailAndPassword(myEmail, myPass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getActivity(), "Logging in", Toast.LENGTH_SHORT).show();
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
