package com.example.android.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignUpTabFragment extends Fragment
{
    EditText name, email, mobile, pass, confirm;
    Button signUpButton;
    float v=0;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        name = root.findViewById(R.id.nameSignUp);
        email = root.findViewById(R.id.emailSignUp);
        mobile = root.findViewById(R.id.mobileNum);
        pass = root.findViewById(R.id.password);
        confirm = root.findViewById(R.id.confirmPassword);
        signUpButton = root.findViewById(R.id.signUpButton);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        name.setTranslationX(800);
        email.setTranslationX(800);
        mobile.setTranslationX(800);
        pass.setTranslationX(800);
        confirm.setTranslationX(800);
        signUpButton.setTranslationX(800);

        name.setAlpha(v);
        email.setAlpha(v);
        mobile.setAlpha(v);
        pass.setAlpha(v);
        confirm.setAlpha(v);
        signUpButton.setAlpha(v);

        name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
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
                String myName = name.getText().toString().trim();
                String myPhone = mobile.getText().toString().trim();

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

                                    // store user data in cloud firestore
                                    userID = fAuth.getCurrentUser().getUid();
                                    DocumentReference documentReference = fStore.collection("users").document(userID); // creates if doesn't exist

                                    HashMap<String, Object> fmap = new HashMap<>();
                                    fmap.put("Name", myName);
                                    fmap.put("Phone number", myPhone);
                                    fmap.put("email", myEmail);
                                    fmap.put("password", myPass);

                                    documentReference.set(fmap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d("TAG", "user data stored for: " + myName);
                                        }
                                    });

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
