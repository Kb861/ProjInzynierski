package com.example.ketri.korektawadpostawy.Home.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.BackArrowToHome;
import com.example.ketri.korektawadpostawy.Home.adapter.SliderAdapter;
import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity implements BackArrowToHome {

    @BindView(R.id.slideViewPager)
    ViewPager slideViewPager;

    @BindView(R.id.InfoLayout)
    LinearLayout InfoLayout;

    private SliderAdapter sliderAdapter;
    private TextView[] Dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        sliderAdapter=new SliderAdapter(this);
        slideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);
        SupportActionBarBack();
    }

    public void SupportActionBarBack() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addDotsIndicator(int pos){

        Dots =new TextView[5];

        for(int i=0; i < Dots.length;i++)
        {
            Dots[i]=new TextView(this);
            Dots[i].setText(Html.fromHtml("&#8226;"));
            Dots[i].setTextSize(35);
            Dots[i].setTextColor(getResources().getColor(R.color.transparentWhite));
            InfoLayout.addView(Dots[i]);
        }
            Dots[pos].setTextColor(getResources().getColor(R.color.white));

    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int i) {

            for(int p=0; p < Dots.length;p++){
                Dots[p].setTextColor(getResources().getColor(R.color.transparentWhite));
            }
            Dots[i].setTextColor(getResources().getColor(R.color.white));
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
