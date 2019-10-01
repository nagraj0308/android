package com.nagraj.modelbottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialogDemo extends BottomSheetDialogFragment {
    ButtonSheetlistener buttonSheetlistener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=inflater.inflate(R.layout.bottom_sheet_layout,container,false);
        Button button=view1.findViewById(R.id.doneFilter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSheetlistener.onButtonClick("Button clicked");
                dismiss();
            }
        });

        return view1;
    }

    public interface ButtonSheetlistener{
        void onButtonClick(String string);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            buttonSheetlistener = (ButtonSheetlistener) context;
        }catch (Exception e){

        }

    }
}
