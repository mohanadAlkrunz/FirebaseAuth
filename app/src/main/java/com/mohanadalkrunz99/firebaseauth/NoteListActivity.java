package com.mohanadalkrunz99.firebaseauth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    RecyclerView notesList_rv;
    NoteAdapter noteAdapter;

    List<Note> noteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);



        initData();


        notesList_rv = findViewById(R.id.notesList_rv);
        notesList_rv.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(this ,noteList);
        notesList_rv.setAdapter(noteAdapter);
    }

    private void initData() {


        FirebaseDatabase.getInstance().getReference().child("Note").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot: dataSnapshot.getChildren() ){

                    Note note = snapshot.getValue(Note.class);
                    noteList.add(note);

                }
                noteAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
