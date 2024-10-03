

package com.example.prac03;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prac03.Country;
import com.example.prac03.R;

public class CountryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);


        Country country = (Country) getIntent().getSerializableExtra("country");


        ImageView flagImageView = findViewById(R.id.flagImageView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView capitalTextView = findViewById(R.id.capitalTextView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView populationTextView = findViewById(R.id.populationTextView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView areaTextView = findViewById(R.id.areaTextView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView densityTextView = findViewById(R.id.densityTextView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView worldShareTextView = findViewById(R.id.worldShareTextView);


        flagImageView.setImageResource(country.getFlagResId());
        nameTextView.setText("Nation: " + country.getName());
        capitalTextView.setText("Capital: " + country.getCapital());
        populationTextView.setText("Population: " + country.getPopulation());
        areaTextView.setText("Area: " + country.getArea());
        densityTextView.setText("Density: " + country.getDensity());
        worldShareTextView.setText("World Share: " + country.getWorldShare());
    }
}
