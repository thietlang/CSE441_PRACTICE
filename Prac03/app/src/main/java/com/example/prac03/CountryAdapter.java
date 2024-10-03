package com.example.prac03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private final List<Country> countryList;
    private final OnCountryClickListener listener;

    public CountryAdapter(List<Country> countryList, OnCountryClickListener listener) {
        this.countryList = countryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.bind(country, listener);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView, capitalTextView;
        private ImageView flagImageView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            capitalTextView = itemView.findViewById(R.id.capitalTextView);
            flagImageView = itemView.findViewById(R.id.flagImageView);
        }

        public void bind(Country country, OnCountryClickListener listener) {
            nameTextView.setText(country.getName());
            capitalTextView.setText(country.getCapital());
            flagImageView.setImageResource(country.getFlagResId());
            itemView.setOnClickListener(v -> listener.onCountryClick(country));
        }
    }

    public interface OnCountryClickListener {
        void onCountryClick(Country country);
    }
}
