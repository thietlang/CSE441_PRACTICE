package com.example.prac03;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Country> countryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        countryList.add(new Country("India", "New Delhi", "1.428.6 million people", "2,973,190 Km²", "481 people/Km²", "17.76 %", R.mipmap.coindia));
        countryList.add(new Country("China", "Beijing", "1.412.6 million people", "9,596,961 Km²", "153 people/Km²", "18.47 %", R.drawable.flagchina));
        countryList.add(new Country("USA", "Washington D.C.", "331.4 million people", "9,833,520 Km²", "34 people/Km²", "15.13 %", R.mipmap.comy));
        countryList.add(new Country("Vietnam", "Hanoi", "98.7 million people", "331,212 Km²", "298 people/Km²", "34.3 %", R.mipmap.covn));

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CountryAdapter adapter = new CountryAdapter(countryList, this::onCountryClicked);
        recyclerView.setAdapter(adapter);
    }


    private void onCountryClicked(Country country) {
        Intent intent = new Intent(this, CountryDetailActivity.class);
        intent.putExtra("country", (CharSequence) country);
        startActivity(intent);
    }
}
