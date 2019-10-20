package com.bilgeadam.mobileonlinefoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import com.bilgeadam.mobileonlinefoodapp.activity.MealMenuActivity;
import com.bilgeadam.mobileonlinefoodapp.adapter.MealListRecyclerAdapter;
import com.bilgeadam.mobileonlinefoodapp.adapter.MealListViewAdapter;
import com.bilgeadam.mobileonlinefoodapp.data.Meal;
import com.bilgeadam.mobileonlinefoodapp.dto.JwtTokenRequest;
import com.bilgeadam.mobileonlinefoodapp.dto.JwtTokenResponse;
import com.bilgeadam.mobileonlinefoodapp.services.AuthenticationService;
import com.bilgeadam.mobileonlinefoodapp.utility.RetrofitClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    private void authenticate() {

        AuthenticationService authenticationService = RetrofitClient.getRetrofitInstance(this)
                .create(AuthenticationService.class);
        authenticationService.authenticate(new JwtTokenRequest("mesutcan", "123"))
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String responseString = response.body().string();
                            JwtTokenResponse jwtTokenResponse = new ObjectMapper().readValue(responseString, JwtTokenResponse.class);
                            SharedPreferences sharedPref = getSharedPreferences("BILGEADAMPREF", Context.MODE_PRIVATE);
                            sharedPref.edit().putString("TOKEN", jwtTokenResponse.getToken()).apply();
                            ;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }
}
