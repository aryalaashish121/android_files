package com.example.recycleviewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

//package com.example.recyclerviewsample;
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AniamalViewHolder> {
    List<Animalmodule> animalList;
    Context context;

    public AnimalAdapter(List<Animalmodule> animalList, Context context) {
        this.animalList = animalList;
        this.context = context;
    }

    @NonNull
    @Override
    public AniamalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample,viewGroup,false);
        return new AniamalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final AniamalViewHolder aniamalViewHolder, int i) {
        final Animalmodule animalmodule = animalList.get(i);
        aniamalViewHolder.tvheading.setText(animalmodule.getHeading());
        aniamalViewHolder.img.setImageResource(animalmodule.getImg());

        aniamalViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,animalmodule.getHeading(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class AniamalViewHolder extends RecyclerView.ViewHolder{
    public TextView tvheading;
    public ImageView img;
        public AniamalViewHolder(@NonNull View itemView) {
            super(itemView);

            tvheading = itemView.findViewById(R.id.sample_heading);
            img = itemView.findViewById(R.id.sample_image);

        }
    }
}
