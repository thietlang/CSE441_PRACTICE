package com.example.students_crud_firebase;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FirebaseRecyclerAdapter<T, T1> extends RecyclerView.Adapter {
    public FirebaseRecyclerAdapter(FirebaseRecyclerOptions<T> options) {
    }

    public void startListening() {
    }

    public void stopListening() {
    }

    protected abstract void onBindViewHolder(@NonNull StudentViewHolder holder, int position, @NonNull Student model);

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
