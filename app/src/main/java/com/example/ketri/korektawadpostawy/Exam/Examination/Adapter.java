package com.example.ketri.korektawadpostawy.Exam.Examination;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ketri.korektawadpostawy.Exam.Item;
import com.example.ketri.korektawadpostawy.Exam.Results.ResultActivity;
import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.Exercises.activities.DefectActivity;
import com.example.ketri.korektawadpostawy.Exercises.activities.ExerciseActivity;
import com.example.ketri.korektawadpostawy.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ketri on 02.11.2018.
 */

public class Adapter  extends PagerAdapter {
    @Nullable
    @BindView(R.id.txv_descrip)
    TextView txv_descrip;

    @BindView(R.id.txv_questionExam)
    TextView txv_questionExam;

    @BindView(R.id.img_posture)
    ImageView img_posture;

    private List<Item>items;
    Context context;
    private LayoutInflater layoutInflater;

    public Adapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.examination_item,container,false);
        ButterKnife.bind(this,view);
        img_posture.setImageResource(items.get(position).getBackground());
       // txv_questionExam.setText(items.get(position).getCardName());
        txv_questionExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ExaminationActivity.class);
                intent.putExtra("nameCardView", items.get(position).getCardName());
                context.startActivity(intent);
            }
        });
        txv_descrip.setText(items.get(position).getDescrip());
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
