package com.example.ketri.korektawadpostawy.Home.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        sliderAdapter=new SliderAdapter(this);
        slideViewPager.setAdapter(sliderAdapter);
    }
}
