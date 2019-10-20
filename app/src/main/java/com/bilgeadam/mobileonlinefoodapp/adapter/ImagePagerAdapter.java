package com.bilgeadam.mobileonlinefoodapp.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bilgeadam.mobileonlinefoodapp.dto.Meal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ImagePagerAdapter extends PagerAdapter {

    private List<Meal> campaignMealList = new ArrayList<>();

    @Override
    public int getCount() {
        return campaignMealList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    public void setCampaignMealList(List<Meal> campaignMealList) {
        this.campaignMealList = campaignMealList;
    }
}
