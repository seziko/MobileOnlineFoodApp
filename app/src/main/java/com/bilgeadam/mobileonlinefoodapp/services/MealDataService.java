package com.bilgeadam.mobileonlinefoodapp.services;

import com.bilgeadam.mobileonlinefoodapp.dto.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealDataService  {

    @GET("/meals/all")
    Call<List<Meal>> getMeals();

}
