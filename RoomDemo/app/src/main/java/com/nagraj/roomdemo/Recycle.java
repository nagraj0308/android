package com.nagraj.roomdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycle extends RecyclerView.Adapter<Recycle.VH> {
    List<User> users;

    public Recycle(List<User> users) {
        this.users = users;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.card, parent, false);
        return new VH(listItem);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.fullNameId.setText(users.get(position).getFirstName() + " " +users.get(position).getLastName());
        holder.age.setText(String.valueOf(users.get(position).getAge()));
        holder.tvId.setText(String.valueOf(users.get(position).getUid()));
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        public TextView fullNameId, age,tvId;

        public VH(View itemView) {
            super(itemView);
            this.fullNameId = itemView.findViewById(R.id.fullNameId);
            this.age = itemView.findViewById(R.id.age);
            this.tvId=itemView.findViewById(R.id.tv_id);
        }
    }
}