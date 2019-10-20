package com.bilgeadam.mobileonlinefoodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bilgeadam.mobileonlinefoodapp.R;
import com.bilgeadam.mobileonlinefoodapp.dto.Meal;
import com.bumptech.glide.Glide;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ImagePagerAdapter extends PagerAdapter {

    public ImagePagerAdapter(Context context) {
        this.context = context;
    }

    private Context context;

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

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_image, null);
        ImageView imageView = view.findViewById(R.id.image);

        String url = !campaignMealList.isEmpty() ? campaignMealList.get(position).getPhoto()
                : null;
        if (url != null) {
            Glide.with(context)
                    .load(url)
                    .placeholder(container.getResources().getDrawable(R.color.cardview_dark_background))
                    .into(imageView);
        }

        container.addView(view);
        return view;

    }

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {

        container.removeView((View) view);
    }
}
