package com.example.ketri.korektawadpostawy.Home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ketri on 25.08.2018.
 */

public class SliderAdapter extends PagerAdapter{
    @BindView(R.id.txtHeading)
    TextView txtHeading;

    @BindView(R.id.txt_desc)
    TextView txt_desc;

    @BindView(R.id.imageViewInfo)
    ImageView imageViewInfo;

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images={
        R.mipmap.ic_launcher_scol,
        R.drawable.kif,
        R.drawable.lo,
        R.drawable.plaskie,
            R.drawable.okw

};
    public String[] slide_headings={
            "SKOLIOZA",
            "KIFOZA",
            "LORDOZA",
            "PŁASKIE",
            "OKRĄGŁO-WKLĘSŁE"
    };

    public String[] slide_desc={
            "SKOLIOZApois",
            "KIFOZA opis",
            "LORDOZA opis",
            "PŁASKIE opis",
            "Okragło wklesle opis"
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object o) {
        return view == (RelativeLayout) o;
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position){
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ButterKnife.bind(this,view);
        imageViewInfo.setImageResource(slide_images[position]);
        txtHeading.setText(slide_headings[position]);
        txt_desc.setText(slide_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
