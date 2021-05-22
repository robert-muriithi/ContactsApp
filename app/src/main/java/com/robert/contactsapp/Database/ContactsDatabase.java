package com.robert.contactsapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FamilyEntity.class} , version = 2)

public abstract class ContactsDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "userDB";
    private static ContactsDatabase userDB;

    public static  ContactsDatabase getUserDB(Context context)
    {
        if (userDB == null){
            userDB = Room.databaseBuilder(context,ContactsDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDB;
    }
    public  abstract  ContactsDao userDao();
}
