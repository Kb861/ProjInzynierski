package com.example.ketri.korektawadpostawy.Home.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.Home.adapter.SliderAdapter;
import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {

    @BindView(R.id.slideViewPager)
    ViewPager slideViewPager;
    @BindView(R.id.InfoLayout)
    LinearLayout InfoLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        sliderAdapter=new SliderAdapter(this);
        slideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator();
    }
    public void addDotsIndicator(){
        mDots=new TextView[4];
        for(int i=0;i<mDots.length;i++)
        {
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));
            InfoLayout.addView(mDots[i]);
        }



    }
}
