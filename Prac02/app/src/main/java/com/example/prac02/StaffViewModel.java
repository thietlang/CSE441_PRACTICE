package com.example.prac02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

// Lớp dữ liệu Staff để lưu trữ thông tin nhân viên
class Staff {
    private String id;
    private String fullName;
    private String birthDate;
    private String salary;

    public Staff(String id, String fullName, String birthDate, String salary) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + "-" + fullName + "-" + birthDate + "-" + salary;
    }
}

// Lớp ViewModel quản lý danh sách nhân viên
public class StaffViewModel extends ViewModel {

    // LiveData để lưu trữ danh sách nhân viên
    private MutableLiveData<List<Staff>> staffList;

    public StaffViewModel() {
        // Khởi tạo danh sách nhân viên ban đầu
        staffList = new MutableLiveData<>();
        staffList.setValue(new ArrayList<>());
    }

    // Hàm trả về danh sách nhân viên dưới dạng LiveData
    public LiveData<List<Staff>> getStaffList() {
        return staffList;
    }

    // Hàm để thêm một nhân viên mới vào danh sách
    public void addStaff(String id, String fullName, String birthDate, String salary) {
        List<Staff> currentList = staffList.getValue();
        if (currentList != null) {
            currentList.add(new Staff(id, fullName, birthDate, salary));
            // Cập nhật lại LiveData
            staffList.setValue(currentList);
        }
    }
}
