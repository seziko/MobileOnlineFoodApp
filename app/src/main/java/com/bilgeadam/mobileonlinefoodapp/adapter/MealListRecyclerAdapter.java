package com.bilgeadam.mobileonlinefoodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bilgeadam.mobileonlinefoodapp.R;

import com.bilgeadam.mobileonlinefoodapp.dto.Meal;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MealListRecyclerAdapter extends RecyclerView.Adapter<MealListRecyclerAdapter.MEalViewHolder> {

    private List<Meal> mMealList;
    private Context context;

    /*public MealListRecyclerAdapter(List<Meal> mMealList, Context context) {
        this.mMealList = mMealList;
        this.context = context;
    }*/

    public MealListRecyclerAdapter(List<Meal> mMealList, Context context) {
        this.mMealList = mMealList;
        this.context = context;
    }

    public void setmMealList(List<Meal> mMealList){

    }

    @NonNull
    @Override
    public MEalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meal_card,parent,false);
        return new MEalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MEalViewHolder holder, int position) {
        holder.setData(mMealList.get(position));

    }

    @Override
    public int getItemCount() {
        return mMealList.size();
    }

    class MEalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mealName,mealDescription;
        ImageView mealImage;

        public MEalViewHolder(@NonNull View itemView) {
            super(itemView);
            mealImage = itemView.findViewById(R.id.meal_image);
            mealName = itemView.findViewById(R.id.meal_name);
            mealDescription = itemView.findViewById(R.id.meal_description);
        }

        void setData(Meal meal){
            this.mealName.setText(meal.getName());
            this.mealDescription.setText(meal.getDetail());
            Glide.with(context).load(meal.getPhoto())
                    .centerCrop()
                    .into(mealImage);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
