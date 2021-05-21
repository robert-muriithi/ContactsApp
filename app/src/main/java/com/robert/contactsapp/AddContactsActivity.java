package com.robert.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.robert.contactsapp.Database.ContactsDao;
import com.robert.contactsapp.Database.ContactsDatabase;
import com.robert.contactsapp.Database.FamilyEntity;

public class AddContactsActivity extends AppCompatActivity {
Button add;
EditText contactName, contactNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
        add = findViewById(R.id.addBtn);

        getSupportActionBar().hide();

        contactName = findViewById(R.id.contactName);
        contactNumber = findViewById(R.id.contactNumber);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContact(contactName.getText().toString(),contactNumber.getText().toString());

                Toast.makeText(AddContactsActivity.this, "Contact Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addContact(String name, String phoneNumber){

        ContactsDatabase database = ContactsDatabase.getUserDB(getApplicationContext());

        FamilyEntity entity = new FamilyEntity();
        entity.setContactName(name);
        entity.setPhoneNumber(phoneNumber);
        database.userDao().addContacts(entity);

        finish();
    }
}