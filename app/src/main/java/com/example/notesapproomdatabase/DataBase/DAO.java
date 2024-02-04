package com.example.notesapproomdatabase.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notesapproomdatabase.Models.Notes;

import java.util.List;

@Dao
public interface DAO{
    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    @Query("select * from notes order by id desc")
    List<Notes> getAllNotes();

    @Query("update notes set title=:title, notes=:notes WHERE id=:id")
    void update(int id, String title, String notes);


    @Delete
    void delete(Notes notes);

    @Query("update notes set pinned=:pin where id=:id")
    void pin(int id, boolean pin);





}
