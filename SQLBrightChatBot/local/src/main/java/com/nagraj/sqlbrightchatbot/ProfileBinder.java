package com.nagraj.sqlbrightchatbot;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProfileBinder extends RecyclerView.ViewHolder {
    TextView tvName,tvMobile,tvId;
    ImageView ivDp;
    LinearLayout ll;

    public ProfileBinder(View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_name);
        tvMobile = itemView.findViewById(R.id.tv_mobile);
        tvId = itemView.findViewById(R.id.tv_id);
        ivDp = itemView.findViewById(R.id.iv_dp);
        ll=itemView.findViewById(R.id.ll);
    }
}
