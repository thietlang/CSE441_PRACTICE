package com.example.students_crud_firebase;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    private final TextView txtName;
    private final TextView txtMSSV;
    private final TextView txtClass;
    private final TextView txtScore;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtMSSV = itemView.findViewById(R.id.txtMSSV);
        txtClass = itemView.findViewById(R.id.txtClass);
        txtScore = itemView.findViewById(R.id.txtScore);
    }

    public void bind(Student student) {
        txtName.setText(student.getHoten());
        txtMSSV.setText(student.getMssv());
        txtClass.setText(student.getLop());
        txtScore.setText(String.valueOf(student.getDiem()));
    }
}
