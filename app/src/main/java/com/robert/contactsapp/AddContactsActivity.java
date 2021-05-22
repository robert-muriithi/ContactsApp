package com.robert.contactsapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.robert.contactsapp.Database.ContactsDao;
import com.robert.contactsapp.Database.ContactsDatabase;
import com.robert.contactsapp.Database.FamilyEntity;

public class AddContactsActivity extends AppCompatActivity {
    Button add;
    EditText contactName, contactNumber;
    ContactsDao contactsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
        add = findViewById(R.id.addBtn);

        ContactsDatabase database = ContactsDatabase.getUserDB(getApplicationContext());
        contactsDao = database.userDao();

        getSupportActionBar().hide();

        contactName = findViewById(R.id.contactName);
        contactNumber = findViewById(R.id.contactNumber);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FamilyEntity familyEntity = new FamilyEntity(0, contactName.getText().toString(), contactNumber.getText().toString());
                insertContact(familyEntity);
                Toast.makeText(AddContactsActivity.this, "Contact Added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


    public void insertContact(FamilyEntity familyEntity) {
        new InsertDiseaseAsynTask(contactsDao).execute(familyEntity);
        Toast.makeText(getApplication(), "Added contact", Toast.LENGTH_SHORT).show();
    }

    private static class InsertDiseaseAsynTask extends AsyncTask<FamilyEntity, Void, Void> {

        private ContactsDao contactsDao;

        private InsertDiseaseAsynTask(ContactsDao contactsDao) {
            this.contactsDao = contactsDao;
        }

        @Override
        protected Void doInBackground(FamilyEntity... familyEntities) {
            contactsDao.addContacts(familyEntities[0]);
            return null;
        }
    }
}