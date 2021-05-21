package com.robert.contactsapp.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactsDao {

    @Query("SELECT * FROM FamilyEntity")

    List<ContactsDao> getAllContacts();

    @Insert
    void addContacts (FamilyEntity... familyEntities);


}
