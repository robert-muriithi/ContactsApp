package com.robert.contactsapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "familyEntity")
public class FamilyEntity implements Serializable {

    public FamilyEntity(int id, String contactName, String phoneNumber) {
        this.id = id;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    @PrimaryKey(autoGenerate = true)
    public int id = 0;

    @ColumnInfo(name = "Name")
    String contactName;

    @ColumnInfo(name = "Phone Number")
    String phoneNumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
