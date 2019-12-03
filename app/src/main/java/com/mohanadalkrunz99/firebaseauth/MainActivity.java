package com.mohanadalkrunz99.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.signoutBtn).setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();


        });
    }
}
