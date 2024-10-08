package com.example.bthh3_crud_students;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class StudentDetailActivity extends AppCompatActivity {

    private Student student;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button buttonDelete = findViewById(R.id.buttonDelete);
        TextView textViewDetails = findViewById(R.id.textViewDetails);

        student = (Student) getIntent().getSerializableExtra("student");
        if (student != null) {
            textViewDetails.setText("Họ Tên: " + student.hoTen + "\n" +
                    "Ngày Sinh: " + student.ngaySinh + "\n" +
                    "Email: " + student.email + "\n" +
                    "Địa Chỉ: " + student.diaChi + "\n" +
                    "Chuyên Ngành: " + student.chuyenNganh + "\n" +
                    "GPA: " + student.gpa + "\n" +
                    "Giới Tính: " + student.gioiTinh);
        }
        buttonDelete.setOnClickListener(v -> {

            if (student != null) {
                MainActivity mainActivity = new MainActivity();
                mainActivity.removeStudent(student);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_student_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void deleteStudent() {
        // Truyền dữ liệu trở lại MainActivity
        MainActivity.OnStudentDeletedListener listener = (MainActivity.OnStudentDeletedListener) getParent();
        if (listener != null) {
            listener.onStudentDeleted(student);
        }
        finish();
    }
}

