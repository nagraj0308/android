package com.example.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EnteredData extends Fragment {

    private TextView et1;
    private TextView et2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_entered_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        send(view);
    }
    public void send(View view){
        et1=view.findViewById(R.id.et2);
        et2= view.findViewById(R.id.et4);
    }

    public void setData(Bundle bundle) {
        String name = bundle.getString("Name");
        String email = bundle.getString("Email");
        et1.setText(name);
        et2.setText(email);

    }
}
