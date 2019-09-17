package com.example.frartofrag;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OutputFrag extends Fragment {
    TextView tv1;
    TextView tv2;
    TextView tv3;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_output, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        send(view);
    }
    public void send(View view){
        tv1=view.findViewById(R.id.tv1);
        tv2= view.findViewById(R.id.tv2);
        tv3= view.findViewById(R.id.tv3);
    }

    public void setData(Bundle bundle) {
        String name = bundle.getString("Name");
        String email = bundle.getString("Email");
        String mobile = bundle.getString("Mobile");
        tv1.setText("Name : "+name);
        tv2.setText("Email : "+email);
        tv3.setText("Mobile : "+mobile);
    }


}
