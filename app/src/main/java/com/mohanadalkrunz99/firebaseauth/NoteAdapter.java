package com.mohanadalkrunz99.firebaseauth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.BookVh> {

    Context context ;
    List<Note> notes;

    public NoteAdapter(Context context , List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public BookVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.row_note , parent , false);
        return new BookVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookVh holder, int position) {
        holder.setData(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class BookVh extends RecyclerView.ViewHolder{
      TextView  note_name     , note_desc , note_date;
        public BookVh(@NonNull View itemView) {
            super(itemView);
            note_name = itemView.findViewById(R.id.note_name);
             note_desc = itemView.findViewById(R.id.note_desc);
            note_date = itemView.findViewById(R.id.note_date);
         }

        public void setData(Note note) {
            note_name.setText(note.getTitle());
            note_date.setText(note.getCreatedAt()+"");
            note_desc.setText(note.getDesc());
        }
    }
}
