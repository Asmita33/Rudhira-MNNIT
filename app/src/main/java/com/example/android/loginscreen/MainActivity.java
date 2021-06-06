package com.example.android.loginscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        tv.setText(firebaseAuth.getCurrentUser().getEmail());


    }

    public void logout(View view){

        FirebaseAuth.getInstance().signOut();  // sign out from firebase

        // sign out from google if available
        GoogleSignIn.getClient(this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build())
                .signOut();
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override // try google sign out
//            public void onSuccess(Void aVoid) {
//                startActivity(new Intent(getApplicationContext(), IntroductoryActivity.class));
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {  // failed, means it was a manual sign out
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(getApplicationContext(), IntroductoryActivity.class));
//            }
//        });

        // go to intro
        startActivity(new Intent(getApplicationContext(), IntroductoryActivity.class));
        finish();
    }

}