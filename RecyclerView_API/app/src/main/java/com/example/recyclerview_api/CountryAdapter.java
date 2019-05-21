package com.example.recyclerview_api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview_api.Model.Countries;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    List<Countries> countriesList;
    Context context;

    public CountryAdapter(List<Countries> countriesList, Context context) {
        this.countriesList = countriesList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View itemView= LayoutInflater.from(viewGroup.getContext())
               .inflate(R.layout.sample_row,viewGroup,false);
       return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder countryViewHolder, int i) {

        final Countries countries=countriesList.get(i);
        countryViewHolder.countryName.setText(countries.getCountry());
        Picasso.with(context).load(countries.getFile()).into(countryViewHolder.countryFlag);
    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }

    public class CountryViewHolder extends  RecyclerView.ViewHolder{
        public TextView countryName;
        public ImageView countryFlag;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            countryName=itemView.findViewById(R.id.displayCountryName);
            countryFlag=itemView.findViewById(R.id.displayCountryFlag);
        }
    }
}
