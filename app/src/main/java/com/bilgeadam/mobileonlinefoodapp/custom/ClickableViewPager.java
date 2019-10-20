package com.bilgeadam.mobileonlinefoodapp.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class ClickableViewPager extends ViewPager {

    private OnItemClickListener onItemClickListener;

    public ClickableViewPager(@NonNull Context context) {
        super(context);
        setup();

    }
    public ClickableViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    private void setup() {
        final GestureDetector tapGestureDetector = new GestureDetector(getContext(), new TapGestureListener());
        setOnTouchListener((v, event) -> {
            tapGestureDetector.onTouchEvent(event);
            return false;
        });
    }


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private class TapGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if(onItemClickListener!=null){
                onItemClickListener.onItemClick(getCurrentItem());
            }
            return true;
        }
    }
}
