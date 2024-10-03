package com.example.prac02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;


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


public class StaffViewModel extends ViewModel {


    private MutableLiveData<List<Staff>> staffList;

    public StaffViewModel() {

        staffList = new MutableLiveData<>();
        staffList.setValue(new ArrayList<>());
    }


    public LiveData<List<Staff>> getStaffList() {
        return staffList;
    }


    public void addStaff(String id, String fullName, String birthDate, String salary) {
        List<Staff> currentList = staffList.getValue();
        if (currentList != null) {
            currentList.add(new Staff(id, fullName, birthDate, salary));

            staffList.setValue(currentList);
        }
    }
}
