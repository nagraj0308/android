package com.example.accessfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
        EditText scan;
        Button save,read;
        TextView print,espath,ispath;
        final String filename="program.txt";

        final String epath= Environment.getExternalStorageDirectory().getPath();
        final String ipath=Environment.getRootDirectory().getPath();
       // final String path1=getFilesDir().getPath();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAll();
    }
    public void initAll(){
        ispath=findViewById(R.id.ispath);
        espath=findViewById(R.id.espath);
        ispath.setText(ipath);
        espath.setText(epath);

       // File file=new File(ipath,"fol");
       // file.mkdirs();

        scan=findViewById(R.id.scan);
        save=findViewById(R.id.save);
        read=findViewById(R.id.read);
        print=findViewById(R.id.print);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToFile();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printFromFile();
            }
        });

    }


    public void saveToFile(){
        String txt=scan.getText().toString();
        FileOutputStream fos=null;
        try {
            fos=openFileOutput(filename,MODE_PRIVATE);
            fos.write(txt.getBytes());
            Toast.makeText(this,"Saved to"+getFilesDir()+"/"+filename,Toast.LENGTH_LONG).show();
        }catch (Exception e){


        }finally {
            if(fos!=null){
                try{fos.close();
                }
                catch(Exception e){

                }
            }
        }

    }
    public void printFromFile(){
        FileInputStream fis=null;
        try {
            fis = openFileInput(filename);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String txt;
            while ((txt=br.readLine())!=null){
                sb.append(txt).append("\n");
                print.setText(sb.toString());

            }
        }catch (Exception e){


        }finally {
            if(fis!=null){
                try{fis.close();
                }
                catch(Exception e){

                }
            }
        }

    }
}
