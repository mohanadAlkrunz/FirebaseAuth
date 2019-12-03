package com.mohanadalkrunz99.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null)
        {
            Intent intent = new Intent(SplashActivity.this , MainActivity.class);
            startActivity(intent);
        }

        FirebaseAuth.getInstance().sendPasswordResetEmail("a@a.com");

        findViewById(R.id.signInBtn).setOnClickListener(v->{
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);

        });


        findViewById(R.id.signUpBtn).setOnClickListener(v->{
            Intent intent = new Intent(this,SignUpActivity.class);
            startActivity(intent);

        });

    }
}
