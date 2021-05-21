package com.robert.contactsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.robert.contactsapp.Database.ContactsDao;
import com.robert.contactsapp.Database.ContactsDatabase;
import com.robert.contactsapp.Database.FamilyEntity;

import java.util.List;


public class ContactsListActivity extends AppCompatActivity {

    FloatingActionButton FAB;
    ContactsRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        FAB =findViewById(R.id.fAB);

        Intent intent = getIntent();
        String title = intent.getStringExtra("CONTACT_CATEGORY");

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),AddContactsActivity.class),100);
                //startActivity(new Intent(getApplicationContext(),AddContactsActivity.class));
            }
        });

        initializeRecycler();
        loadContacts();

    }

    private void initializeRecycler() {
        RecyclerView recyclerView = findViewById(R.id.contactslistRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100){

            loadContacts();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void loadContacts() {
        ContactsDatabase database = ContactsDatabase.getUserDB(this.getApplicationContext());
        List<ContactsDao> list = database.userDao().getAllContacts();
       // adapter.setList(list);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}