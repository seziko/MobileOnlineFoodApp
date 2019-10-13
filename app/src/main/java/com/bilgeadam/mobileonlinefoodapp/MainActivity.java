package com.bilgeadam.mobileonlinefoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bilgeadam.mobileonlinefoodapp.activity.MealMenuActivity;
import com.bilgeadam.mobileonlinefoodapp.adapter.MealListRecyclerAdapter;
import com.bilgeadam.mobileonlinefoodapp.adapter.MealListViewAdapter;
import com.bilgeadam.mobileonlinefoodapp.data.Meal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        /*final ListView mealListView = findViewById(R.id.meallistview);
        mealListView.setAdapter(new MealListViewAdapter(this,meals));*/


    }

    public void showMealMenu(View view) {
        Intent mealMenuActivity = new Intent(this, MealMenuActivity.class);
        startActivity(mealMenuActivity);

    }
}
