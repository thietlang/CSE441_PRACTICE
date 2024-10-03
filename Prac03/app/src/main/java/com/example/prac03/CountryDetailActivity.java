

package com.example.populationapp;

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

        // Lấy dữ liệu từ Intent
        Country country = (Country) getIntent().getSerializableExtra("country");

        // Liên kết các view với layout
        ImageView flagImageView = findViewById(R.id.flagImageView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView capitalTextView = findViewById(R.id.capitalTextView);
        TextView populationTextView = findViewById(R.id.populationTextView);
        TextView areaTextView = findViewById(R.id.areaTextView);
        TextView densityTextView = findViewById(R.id.densityTextView);
        TextView worldShareTextView = findViewById(R.id.worldShareTextView);

        // Hiển thị dữ liệu quốc gia
        flagImageView.setImageResource(country.getFlagResId());
        nameTextView.setText("Nation: " + country.getName());
        capitalTextView.setText("Capital: " + country.getCapital());
        populationTextView.setText("Population: " + country.getPopulation());
        areaTextView.setText("Area: " + country.getArea());
        densityTextView.setText("Density: " + country.getDensity());
        worldShareTextView.setText("World Share: " + country.getWorldShare());
    }
}
