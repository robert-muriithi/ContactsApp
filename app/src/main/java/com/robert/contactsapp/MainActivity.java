package com.robert.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeRecyclerview();


    }

    private void initializeRecyclerview() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ArrayList<String> contacts = new ArrayList<>();

        contacts.add("Family");
        contacts.add("Friends");
        contacts.add("Students");
        contacts.add("Tutors");
        contacts.add("Colleagues");
        contacts.add("Teachers");
        contacts.add("Lecturers");

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(contacts, this);
        recyclerView.setAdapter(recyclerAdapter);
    }
}