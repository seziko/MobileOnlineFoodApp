package com.bilgeadam.mobileonlinefoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bilgeadam.mobileonlinefoodapp.adapter.MealListViewAdapter;
import com.bilgeadam.mobileonlinefoodapp.data.Meal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Mantı","desc","https://i4.hurimg.com/i/hurriyet/75/1500x844/5cdfce0667b0a90adcf9aec5.jpg"));
        meals.add(new Meal("Çorba","desc","https://i4.hurimg.com/i/hurriyet/75/750x422/5c1b951f0f254432c40e6457.jpg"));
        meals.add(new Meal("Kavurma","desc","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQm8bhxp6Nnm8Q4oFcxb4sAhxvqDNjkC2OIXO3d4Ro2kJwPcnZb"));

        final ListView mealListView = findViewById(R.id.meallistview);
        mealListView.setAdapter(new MealListViewAdapter(this,meals));

    }

}
