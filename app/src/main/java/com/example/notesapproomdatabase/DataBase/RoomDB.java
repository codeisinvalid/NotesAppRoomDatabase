package com.example.notesapproomdatabase.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notesapproomdatabase.Models.Notes;

@Database(entities = Notes.class, exportSchema = false, version = 1)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB database;
    private final static String DB_NAME = "NotesApp";

    public static synchronized RoomDB getInstance(Context context){
        if (database == null){
            database = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class, DB_NAME).allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();
        }
        return database;
    }

    public abstract DAO dao();
}
