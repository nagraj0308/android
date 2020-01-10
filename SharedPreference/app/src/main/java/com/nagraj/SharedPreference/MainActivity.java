package com.nagraj.SharedPreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    TextView tvBoard;
    EditText etKey,etValue;
    Button buttonAdd,buttonDelete,buttonClear,buttonShow,buttonModify;
    SharedPreferences sharedPreferences;
    HashMap<String,String> hashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvBoard=findViewById(R.id.tvBoard);
        etKey=findViewById(R.id.etKey);
        etValue=findViewById(R.id.etValue);
        buttonAdd=findViewById(R.id.bAdd);
        buttonClear=findViewById(R.id.bClear);
        buttonDelete=findViewById(R.id.bDelete);
        buttonShow=findViewById(R.id.bShow);
        buttonModify=findViewById(R.id.bModify);
        sharedPreferences=getApplicationContext().getSharedPreferences("NagRaj",0);
        onClickButtons();
    }
    private void onClickButtons(){
        hashMap=new HashMap<>();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(etKey.getText().toString().trim(),etValue.getText().toString().trim()).apply();
                editor.commit();
                hashMap.put(etKey.getText().toString().trim(),sharedPreferences.getString(etKey.getText().toString().trim(),"default"));
                showAllData();
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.remove(etKey.getText().toString().trim()).apply();
                editor.commit();
                hashMap.remove(etKey.getText().toString().trim());
                showAllData();

            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear().apply();
                editor.commit();
                hashMap.clear();
                showAllData();

            }
        });
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAllData();
            }
        });
        buttonModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(etKey.getText().toString().trim(),etValue.getText().toString().trim()).apply();
                editor.commit();
                hashMap.put(etKey.getText().toString().trim(),sharedPreferences.getString(etKey.getText().toString().trim(),"default"));
                showAllData();
            }
        });
    }

    public void showAllData(){
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        String string="";
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            string+=mentry.getKey() + "    "+sharedPreferences.getString(mentry.getKey().toString(),"")+"\n";
        }
        tvBoard.setText(string);
    }
}
