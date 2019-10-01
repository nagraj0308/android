package com.nagraj.modelbottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements BottomSheetDialogDemo.ButtonSheetlistener {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialogDemo bottomSheetDialogDemo=new BottomSheetDialogDemo();
                bottomSheetDialogDemo.show(getSupportFragmentManager(),"exampleBottomsheet");

            }
        });
    }
    @Override
   public void onButtonClick(String string){
        textView.setText(string);
    }
}
