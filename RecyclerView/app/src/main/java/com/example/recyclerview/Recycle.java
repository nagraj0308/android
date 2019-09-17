package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Recycle extends RecyclerView.Adapter<Recycle.VH> {
    String[] data;

    public Recycle(String[] listdata) {
        this.data = listdata;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.listbox, parent, false);
        return new VH(listItem);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        String title = data[position];
        holder.name.setText(title);
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class VH extends RecyclerView.ViewHolder {
        public TextView name;

        public VH(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
        }
    }
}