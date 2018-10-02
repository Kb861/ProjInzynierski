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
            R.drawable.scoliosis,
            R.drawable.kyphosis,
            R.drawable.lordosis,
            R.drawable.flat,
            R.drawable.round
};
    public String[] slide_headings={
            "SKOLIOZA",
            "KIFOZA",
            "LORDOZA",
            "PLECY PŁASKIE",
            "PLECY OKRĄGŁO-WKLĘSŁE"
    };
    public String[] slide_desc={
            "Charakteryzuje się odchyleniem od osi anatomicznej kręgosłupa lub jego odcinka w płaszczyźnie czołowej.",
            "Charakteryzuje się nadmiernym wygięciem jednego odcinka lub całęgo kręgosłupa ku tyłowi",
            "Wada polega na pogłębieniu lordozy lędźwiowej czyli wygięcia ku przodowi w płaszczyźnie strzałkowej.",
            "Wada charakteryzuje się spłaszczeniem lub brakiem fizjiologicznych wygięć kręgosłupa.",
            "Charakterystyczną cechą tej wady jest zwiękoszona lordoza lędźwiowa i kifoza piersiowa. Zazwyczaj głowa jest pochylona ku przodowi, a klatka piersiowa spłaszczona."
    }; //nie działa z R.array...
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
