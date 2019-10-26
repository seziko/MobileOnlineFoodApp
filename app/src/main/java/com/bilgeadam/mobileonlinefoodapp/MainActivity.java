package com.bilgeadam.mobileonlinefoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import com.bilgeadam.mobileonlinefoodapp.activity.MealMenuActivity;
import com.bilgeadam.mobileonlinefoodapp.adapter.ImagePagerAdapter;
import com.bilgeadam.mobileonlinefoodapp.adapter.MealListRecyclerAdapter;
import com.bilgeadam.mobileonlinefoodapp.adapter.MealListViewAdapter;
import com.bilgeadam.mobileonlinefoodapp.dto.JwtTokenRequest;
import com.bilgeadam.mobileonlinefoodapp.dto.JwtTokenResponse;
import com.bilgeadam.mobileonlinefoodapp.dto.Meal;
import com.bilgeadam.mobileonlinefoodapp.services.AuthenticationService;
import com.bilgeadam.mobileonlinefoodapp.services.MealDataService;
import com.bilgeadam.mobileonlinefoodapp.utility.RetrofitClient;
import com.bilgeadam.mobileonlinefoodapp.utility.UpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImagePagerAdapter imagePagerAdapter;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        /*final ListView mealListView = findViewById(R.id.meallistview);
        mealListView.setAdapter(new MealListViewAdapter(this,meals));*/
        authenticate();
        configureSlider();



    }

    private void configureSlider(){
        viewPager = findViewById(R.id.image_pager);
        imagePagerAdapter = new ImagePagerAdapter(this);
        viewPager.setAdapter(imagePagerAdapter);
        UpUtils.automaticSlide(viewPager,imagePagerAdapter);
        circleIndicator = findViewById(R.id.circle);
        circleIndicator.setViewPager(viewPager);

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
                            getMeals();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }

    private void getMeals(){
        MealDataService mealDataService = RetrofitClient.getRetrofitInstance(this).create(MealDataService.class);
        mealDataService.getMeals().enqueue(new Callback<List<com.bilgeadam.mobileonlinefoodapp.dto.Meal>>() {
            @Override
            public void onResponse(Call<List<com.bilgeadam.mobileonlinefoodapp.dto.Meal>> call, Response<List<com.bilgeadam.mobileonlinefoodapp.dto.Meal>> response) {
                imagePagerAdapter.setCampaignMealList(response.body());
                imagePagerAdapter.notifyDataSetChanged();
                circleIndicator = findViewById(R.id.circle);
                circleIndicator.setViewPager(viewPager);
            }

            @Override
            public void onFailure(Call<List<Meal>> call, Throwable t) {

            }

        });

    }
    private void getCampaign(){
        MealDataService mealDataService = RetrofitClient.getRetrofitInstance(this).create(MealDataService.class);
        mealDataService.getCampaign().enqueue(new Callback<List<Meal>>() {
            @Override
            public void onResponse(Call<List<com.bilgeadam.mobileonlinefoodapp.dto.Meal>> call,
                                   Response<List<com.bilgeadam.mobileonlinefoodapp.dto.Meal>> response) {
                imagePagerAdapter.setCampaignMealList(response.body());
                imagePagerAdapter.notifyDataSetChanged();
                circleIndicator = findViewById(R.id.circle);
                circleIndicator.setViewPager(viewPager);
            }

            @Override
            public void onFailure(Call<List<Meal>> call, Throwable t) {

            }
        });
    }
}
