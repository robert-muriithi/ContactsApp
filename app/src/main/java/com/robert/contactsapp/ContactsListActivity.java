package com.robert.contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.robert.contactsapp.Database.ContactsDao;
import com.robert.contactsapp.Database.ContactsDatabase;
import com.robert.contactsapp.Database.FamilyEntity;

import java.util.ArrayList;
import java.util.List;


public class ContactsListActivity extends AppCompatActivity {

    FloatingActionButton FAB;
    ContactsRecyclerAdapter adapter;
    List<FamilyEntity> list = new ArrayList<>();
    private static final String TAG = "ContactsListActivity";

    ContactsDao contactsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        FAB = findViewById(R.id.fAB);

        ContactsDatabase database = ContactsDatabase.getUserDB(getApplicationContext());
        contactsDao = database.userDao();

        Intent intent = getIntent();
        String title = intent.getStringExtra("CONTACT_CATEGORY");

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddContactsActivity.class));
            }
        });

        loadContacts();
        initializeRecycler();

    }

    private void initializeRecycler() {
        RecyclerView recyclerView = findViewById(R.id.contactslistRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
    }

    private void loadContacts() {
        list = contactsDao.getAllContacts();
        Log.d(TAG, "loadContacts: " + list.get(0).getContactName());
        adapter = new ContactsRecyclerAdapter(list);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}