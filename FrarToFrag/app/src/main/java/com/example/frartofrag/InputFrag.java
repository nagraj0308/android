package com.example.frartofrag;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class InputFrag extends Fragment {

    TextView et1;
    TextView et2;
    TextView et3;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.et1);
        et2 = view.findViewById(R.id.et2);
        et3 = view.findViewById(R.id.et3);
        Button et4 = view.findViewById(R.id.et4);
        et4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                send();
            }
        });
    }

    public void send() {

        MainActivity m1 = (MainActivity) getActivity();
        m1.getData(et1.getText().toString(), et2.getText().toString(), et3.getText().toString());
    }


}
