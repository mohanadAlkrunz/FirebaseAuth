package com.mohanadalkrunz99.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView note_content;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        note_content = findViewById(R.id.note_content);
        findViewById(R.id.signoutBtn).setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();
        });

         findViewById(R.id.goToNotesList).setOnClickListener(v->{

             Intent intent = new Intent(MainActivity.this,NoteListActivity.class);
             startActivity(intent);
        });





        findViewById(R.id.addNewNoteBtn).setOnClickListener(v->{

            Note note = new Note();
            note.setCreatedAt(new Date().getTime());
            note.setLastUpdate(new Date().getTime());
            note.setTitle("Test Note Title");
            note.setDesc("Tet Node Description");


            String id = FirebaseDatabase.getInstance().getReference().child("Note").push().getKey();
            note.setId(id);
            FirebaseDatabase.getInstance().getReference().child("Note").child(id).setValue(note);

        });


        FirebaseDatabase.getInstance().getReference().child("Note").child("-LvZyjvGPh8rLz2SWo3z")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Long createdAt = dataSnapshot.child("createdAt").getValue(Long.class);
                        String desc = dataSnapshot.child("desc").getValue().toString();
                        String id = dataSnapshot.child("id").getValue(String.class);
                        String title = dataSnapshot.child("title").getValue(String.class);


                        note_content.setText(title + " " +desc );
                        Toast.makeText(MainActivity.this, title + " " +desc, Toast.LENGTH_SHORT).show();

                        Log.d("onDataChange",title + " " +desc);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {    }
                });


    }
}
