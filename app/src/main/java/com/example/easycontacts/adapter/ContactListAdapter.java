package com.example.easycontacts.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.easycontacts.R;
import com.example.easycontacts.model.db.Contact;

import java.util.List;

/**
 * Created by xkrej63 on 29.05.2018.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    private List<Contact> contacts;

    public OnContactItemInteracted listener;

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.onBind(contact);
    }

    @Override
    public int getItemCount() {
        return contacts != null ? contacts.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        void onBind(final Contact contact) {
            TextView textTitleView = itemView.findViewById(R.id.textTitleView);
            TextView textSubtitleView = itemView.findViewById(R.id.textSubtitleView);

            textTitleView.setText(contact.getDisplayName());
            textSubtitleView.setText(contact.getPrimaryContactInfo());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onContactClicked(contact);
                    }
                }
            });
        }
    }

    public interface OnContactItemInteracted {
        void onContactClicked(Contact contact);
    }
}
