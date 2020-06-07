package com.nagraj.sqlbrightchatbot;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfileRecyclerAdapter extends RecyclerView.Adapter<ProfileBinder> {
    Context context;
    List<Profile> profileList;

    public  ProfileRecyclerAdapter(Context context,List<Profile> profileList) {
        this.context=context;
        this.profileList = profileList;
    }

    @Override
    public ProfileBinder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.profile_view, parent, false);
        return new ProfileBinder(listItem);
    }

    @Override
    public void onBindViewHolder(ProfileBinder holder, int position) {
        Profile profile = profileList.get(position);
        holder.tvName.setText(profile.getName());
        holder.tvId.setText(profile.getId()+"");
        holder.tvMobile.setText(profile.getMobileNo());
        holder.ivDp.setImageDrawable(profile.isGender()? ContextCompat.getDrawable(context, R.drawable.f):ContextCompat.getDrawable(context, R.drawable.m));
        holder.ll.setBackgroundColor(profile.isGender()?ContextCompat.getColor(context,R.color.red):ContextCompat.getColor(context,R.color.pink));
    }


    @Override
    public int getItemCount() {
        return profileList.size();
    }

}
