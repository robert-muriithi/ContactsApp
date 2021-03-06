package com.robert.contactsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robert.contactsapp.Database.FamilyEntity;

import java.util.List;


public class ContactsRecyclerAdapter extends RecyclerView.Adapter<ContactsRecyclerAdapter.ViewHolder> {

    private static final String TAG = "ContactsRecyclerAdapter";

    List<FamilyEntity> list;

    public ContactsRecyclerAdapter(List<FamilyEntity> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ContactsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsRecyclerAdapter.ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getContactName());
        holder.number.setText(list.get(position).getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView contact_image;
        TextView name, number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contact_image = itemView.findViewById(R.id.contact_image);
            name = itemView.findViewById(R.id.nameContact);
            number = itemView.findViewById(R.id.numberContact);
        }
    }
}
