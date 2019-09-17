package com.example.jsonsimple;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.VH> {
    JSONArray contactList;

    public ContactsAdapter(String cl) {
        try {
            JSONObject jsonObj = new JSONObject(cl);

            this.contactList = jsonObj.getJSONArray("contacts");
        } catch (Exception e) {
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.profile, parent, false);
        return new VH(listItem);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        try {
            JSONObject c = contactList.getJSONObject(position);
            String n = c.getString("name");
            String e = c.getString("email");
            String g = c.getString("gender");
            holder.name.setText(n);
            holder.email.setText(e);
            if (g.equals("female")) {
                holder.gender.setBackgroundResource(R.drawable.f);
            }
            else{
                holder.gender.setBackgroundResource(R.drawable.m);
            }
        } catch (Exception e) {

        }
    }


            @Override
            public int getItemCount () {
                return contactList.length() ;
            }

            public class VH extends RecyclerView.ViewHolder {
                public TextView name;
                public TextView gender;
                public TextView email;

                public VH(View itemView) {
                    super(itemView);
                    this.name = itemView.findViewById(R.id.name);
                    this.email = itemView.findViewById(R.id.email);
                    this.gender = itemView.findViewById(R.id.gender);
                }
            }
        }
