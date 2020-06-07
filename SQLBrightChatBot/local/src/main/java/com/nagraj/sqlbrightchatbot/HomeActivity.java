package com.nagraj.sqlbrightchatbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rvProfileList;
    List<Profile> profileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initilise();

    }

    public  void  initilise(){
        rvProfileList=findViewById(R.id.rv_profile_list);
        profileList=new ArrayList<>();
        int j=0,n=10;
        while (j<n) {
            profileList.add(new Profile("Nagendra"+j, "706019603"+(j%10), 100+j, (j%3)==1));
            j++;
        }
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvProfileList.setLayoutManager(llm);
        rvProfileList.setAdapter(new ProfileRecyclerAdapter(this,profileList));
    }
}
