package com.example.students_crud_firebase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentActivity extends AppCompatActivity {
    private EditText edtName, edtMSSV, edtClass, edtScore;
    private Button btnSave;
    private FirebaseDatabase database;
    private DatabaseReference studentRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        edtName = findViewById(R.id.edtName);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtClass = findViewById(R.id.edtClass);
        edtScore = findViewById(R.id.edtScore);
        btnSave = findViewById(R.id.btnSave);

        database = FirebaseDatabase.getInstance();
        studentRef = database.getReference("sinhvien");

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            String mssv = edtMSSV.getText().toString();
            String lop = edtClass.getText().toString();
            String diem = edtScore.getText().toString();

            if (!name.isEmpty() && !mssv.isEmpty() && !lop.isEmpty() && !diem.isEmpty()) {
                Student student = new Student(name, mssv, lop, Double.parseDouble(diem));
                studentRef.child(mssv).setValue(student).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(AddStudentActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddStudentActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(AddStudentActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

