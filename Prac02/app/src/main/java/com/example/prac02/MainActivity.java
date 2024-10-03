package com.example.prac02;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StaffViewModel staffViewModel;
    private EditText etStaffId, etFullName, etBirthDate, etSalary;
    private TextView tvStaffList;
    private Button btnAddStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etStaffId = findViewById(R.id.etStaffId);
        etFullName = findViewById(R.id.etFullName);
        etBirthDate = findViewById(R.id.etBirthDate);
        etSalary = findViewById(R.id.etSalary);
        tvStaffList = findViewById(R.id.tvStaffList);
        btnAddStaff = findViewById(R.id.btnAddStaff);


        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);


        staffViewModel.getStaffList().observe(this, new Observer<List<Staff>>() {
            @Override
            public void onChanged(List<Staff> staffList) {
                if (staffList.isEmpty()) {
                    tvStaffList.setText("No Result!");
                } else {
                    StringBuilder result = new StringBuilder();
                    for (Staff staff : staffList) {
                        result.append(staff.toString()).append("\n");
                    }
                    tvStaffList.setText(result.toString());
                }
            }
        });

        btnAddStaff.setOnClickListener(v -> {
            String id = etStaffId.getText().toString();
            String fullName = etFullName.getText().toString();
            String birthDate = etBirthDate.getText().toString();
            String salary = etSalary.getText().toString();

            if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(fullName) && !TextUtils.isEmpty(birthDate) && !TextUtils.isEmpty(salary)) {

                staffViewModel.addStaff(id, fullName, birthDate, salary);

                clearInputFields();
            } else {
                tvStaffList.setText("Chưa nhập đủ dữ liệu");
            }
        });
    }

    private void clearInputFields() {
        etStaffId.setText("");
        etFullName.setText("");
        etBirthDate.setText("");
        etSalary.setText("");
    }
}
