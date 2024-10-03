package com.example.project_cal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2, edt3;
    Button btncong, btntru, btnnhan, btnchia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Đảm bảo activity_main.xml đúng và chứa tất cả các view cần thiết.

        // Khởi tạo các view từ layout
        edt1 = findViewById(R.id.edta);
        edt2 = findViewById(R.id.edtb);
        edt3 = findViewById(R.id.edtc);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnchia = findViewById(R.id.btnchia);
        btnnhan = findViewById(R.id.btnnhan);

        // Xử lý sự kiện cho các nút
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperation("+");
            }
        });

        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperation("-");
            }
        });

        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperation("*");
            }
        });

        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperation("/");
            }
        });
    }

    // Phương thức xử lý các phép tính
    private void handleOperation(String operation) {
        String input1 = edt1.getText().toString().trim();
        String input2 = edt2.getText().toString().trim();

        // Kiểm tra nếu người dùng không nhập gì
        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số", Toast.LENGTH_SHORT).show();
            return;
        }

        // Thử chuyển đổi dữ liệu từ EditText sang số nguyên
        try {
            int a = Integer.parseInt(input1);
            int b = Integer.parseInt(input2);

            switch (operation) {
                case "+":
                    edt3.setText("a + b = " + (a + b));
                    break;
                case "-":
                    edt3.setText("a - b = " + (a - b));
                    break;
                case "*":
                    edt3.setText("a * b = " + (a * b));
                    break;
                case "/":
                    if (b == 0) {
                        edt3.setText("B phải khác 0");
                    } else {
                        edt3.setText("a / b = " + (a / b));
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            // Nếu không thể chuyển đổi sang số
            Toast.makeText(this, "Dữ liệu nhập không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}
