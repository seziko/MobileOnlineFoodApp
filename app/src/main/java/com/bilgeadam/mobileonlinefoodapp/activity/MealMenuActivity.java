package com.bilgeadam.mobileonlinefoodapp.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bilgeadam.mobileonlinefoodapp.R;
import com.bilgeadam.mobileonlinefoodapp.adapter.MealListRecyclerAdapter;
import com.bilgeadam.mobileonlinefoodapp.data.Meal;

import java.util.ArrayList;

public class MealMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_menu);

        ArrayList<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Mantı","desc","https://i4.hurimg.com/i/hurriyet/75/1500x844/5cdfce0667b0a90adcf9aec5.jpg"));
        meals.add(new Meal("Çorba","desc","https://i4.hurimg.com/i/hurriyet/75/750x422/5c1b951f0f254432c40e6457.jpg"));
        meals.add(new Meal("Kavurma","desc","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQm8bhxp6Nnm8Q4oFcxb4sAhxvqDNjkC2OIXO3d4Ro2kJwPcnZb"));

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        RecyclerView mRecyclerView = findViewById(R.id.meallistrecyclerview);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(new MealListRecyclerAdapter(meals,this));
        MealListRecyclerAdapter mealListRecyclerAdapter = new MealListRecyclerAdapter(meals,this);
        mRecyclerView.setAdapter(mealListRecyclerAdapter);
    }
}
