package com.nagraj.roomdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycle extends RecyclerView.Adapter<Recycle.VH> {
    User[] data;

    public Recycle(User[] listdata) {
        this.data = listdata;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.card, parent, false);
        return new VH(listItem);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        String title = data[position].getFirstName() + " " + data[position].getLastName() + " " + data[position].getUid();
        holder.fullNameId.setText(title);
        holder.age.setText("" + data[position].getAge());
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class VH extends RecyclerView.ViewHolder {
        public TextView fullNameId, age;

        public VH(View itemView) {
            super(itemView);
            this.fullNameId = itemView.findViewById(R.id.fullNameId);
            this.age = itemView.findViewById(R.id.age);
        }
    }
}