package com.robert.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;


public class ContactsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        //getSupportActionBar().hide();

        Intent intent = getIntent();
        String title = intent.getStringExtra("CONTACT_CATEGORY");

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        *//*toolbar.setTitle(title);
        setSupportActionBar(toolbar);*/

        getSupportActionBar().setTitle(title);


    }
}