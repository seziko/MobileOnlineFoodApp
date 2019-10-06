package com.bilgeadam.mobileonlinefoodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bilgeadam.mobileonlinefoodapp.R;
import com.bilgeadam.mobileonlinefoodapp.data.Meal;
import com.bumptech.glide.Glide;

import java.util.List;

public class MealListViewAdapter extends ArrayAdapter<Meal> {

    private List<Meal> meals;

    public MealListViewAdapter(Context context, List<Meal> meals) {
        super(context, R.layout.meal_card);
        this.meals = meals;
    }

    @Override
    public int getCount() {
        return meals.size();
    }


    @Override
    public Meal getItem(int index) {
        return meals.get(index);
    }


    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView,
                 @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)
                this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = layoutInflater.inflate(R.layout.meal_card, parent , false);

        Meal meal = meals.get(position);

        ImageView mealImage = itemView.findViewById(R.id.meal_image);
        Glide.with(getContext()).load(meal.getImage()).centerCrop().into(mealImage);

        //mealImage.setImageDrawable(getContext().getDrawable(R.mipmap.ic_launcher));
        TextView mealName = itemView.findViewById(R.id.meal_name);
        mealName.setText(meal.getName());
        TextView mealDescription = itemView.findViewById(R.id.meal_description);
        mealDescription.setText(meal.getDescription());
        return itemView;
    }
}

