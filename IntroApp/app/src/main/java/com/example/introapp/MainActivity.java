package com.example.introapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<IntroSlide> introSlides = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        introSlides.add(new IntroSlide(R.mipmap.cothoiNgo, "Nhà Ngô!",""));
                introSlides.add(new IntroSlide(R.mipmap.cothoiLy, "Tính năng nổi bật", "Ứng dụng cung cấp nhiều tính
                        năng hữu ích giúp bạn..."));
        introSlides.add(new IntroSlide(R.mipmap.cothoiTran, "Dễ sử dụng", "Giao diện thân thiện, dễ sử dụng cho
                mọi người."));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}