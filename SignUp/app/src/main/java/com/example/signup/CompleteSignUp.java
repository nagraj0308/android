package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CompleteSignUp extends AppCompatActivity {

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_complete_sign_up);

        bundle = new Bundle();
        bundle.putString("Name", getIntent().getStringExtra("Name"));
        bundle.putString("Email", getIntent().getStringExtra("Email"));
        EnteredData fragobj = new EnteredData();
        fragobj.setArguments(bundle);
    }

    public void completeSignUp(View view) {
        startActivity(new Intent(this, MainActivity.class));

    }

    public void data(View view) {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.fragment);
        ((EnteredData) frag).setData(bundle);
        if (frag.isVisible())
            frag.getView().setVisibility(View.GONE);
        else
            frag.getView().setVisibility(View.VISIBLE);
    }



}

