package com.nagraj.parcelabledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.nagraj.parcelabledemo.MainActivity.HOUSE_KEY;

public class DetailActivity extends AppCompatActivity {

    private House house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        house = getIntent().getParcelableExtra(HOUSE_KEY);

        if (house != null) {
            populateViews();
        }
    }

    private void populateViews() {

        TextView priceView = findViewById(R.id.priceView);
        priceView.setText(Integer.toString(house.getPrice()));

        TextView locationView = findViewById(R.id.locationView);
        locationView.setText(house.getLocation());

        TextView isNearSchoolView = findViewById(R.id.nearSchoolView);
        isNearSchoolView.setText(((Boolean) house.getIsNearSchool()).toString());

        TextView previousOwnersView = findViewById(R.id.previousOwnerView);
        previousOwnersView.setText((house.getPreviousOwners()).toString());

    }
}

