package com.example.notesapproomdatabase;

import androidx.cardview.widget.CardView;

import com.example.notesapproomdatabase.Models.Notes;

public interface NotesClick {

    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);


}
