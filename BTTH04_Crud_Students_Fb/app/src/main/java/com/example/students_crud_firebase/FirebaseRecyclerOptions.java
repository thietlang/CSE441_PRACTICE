package com.example.students_crud_firebase;

import com.google.firebase.database.DatabaseReference;

import java.security.cert.CertPathBuilder;

public class FirebaseRecyclerOptions<T> {
    public static class Builder<T> {
        public CertPathBuilder setQuery(DatabaseReference studentRef, Class<Student> studentClass) {
            return null;
        }
    }
}
