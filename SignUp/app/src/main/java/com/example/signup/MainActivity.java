package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signUp(View view){
        EditText et1=(EditText)findViewById(R.id.et1);
        EditText et2=(EditText)findViewById(R.id.et2);
        Intent i=new Intent(this,CompleteSignUp.class);
        i.putExtra("Name",et1.getText().toString());
        i.putExtra("Email",et2.getText().toString());
      // startActivity(new Intent(this,CompleteSignUp.class));
        startActivity(i);
    }


}
