package com.example.frartofrag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Bundle bundle;
    String s1="hi",s2="hello",s3="hai";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void input(View view) {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.input);
        if (frag.isVisible()) {
            frag.getView().setVisibility(View.GONE);
        }
        else
            frag.getView().setVisibility(View.VISIBLE);
    }
    public void output(View view) {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.output);
        bundle = new Bundle();
        bundle.putString("Name",s1);
        bundle.putString("Email",s2);
        bundle.putString("Mobile",s3);
        OutputFrag fragobj = new OutputFrag();
        fragobj.setArguments(bundle);
        ((OutputFrag) frag).setData(bundle);
        if (frag.isVisible())
            frag.getView().setVisibility(View.GONE);
        else
            frag.getView().setVisibility(View.VISIBLE);
    }
    public void getData(String t1,String t2,String t3){
        s1=t1;
        s2=t2;
        s3=t3;

    }


}
