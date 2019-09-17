package com.example.spinnerdemo;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        Spinner sp ;
        TextView tv1 ;
        String names[] = {"Select","Red","Blue","Green"};
        ArrayAdapter <String> adapter;
        String record= "";

        @Override

        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            sp = (Spinner)findViewById(R.id.spinner);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
            sp.setAdapter(adapter);


            tv1 = (TextView)findViewById(R.id.tv1);

            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override

                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position)

                    {

                        case 0:

                            record = "Nothing Selected";

                            break;

                        case 1:

                            record = "Red";

                            break;

                        case 3:

                            record = "Green";

                            break;
                        case 2:

                            record = "Blue";

                            break;

                    }

                }

                @Override

                public void onNothingSelected(AdapterView<?> parent) {



                }

            });

        }

        //set display button click to show result

        public void diplsyResult(View view)

        {

            tv1.setTextSize(18);

            tv1.setText(record);

        }


}