package com.example.universities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder> {
    private Context context;
    private ArrayList<Model> universityList;


    public UniversityAdapter(Context context, ArrayList<Model> universityList)
    {
        this.context = context;
        this.universityList = universityList;
    }

    @NonNull
    @Override
    public UniversityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UniversityViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityViewHolder holder, int position) {
        Model model = universityList.get(position);
        holder.mName.setText(model.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                Bundle extras = new Bundle();
                extras.putString("name",model.getName());
                extras.putString("state",model.getStateProvince());
                extras.putString("webPage",model.getWebPages()[0]);
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return universityList.size();
    }
    public void setUniversityList(ArrayList<Model> universityList)
    {
        this.universityList = universityList;
    }


    public static  class UniversityViewHolder extends  RecyclerView.ViewHolder{

        public TextView mName;

        public UniversityViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.UniversityNAme);
        }
    }
}
