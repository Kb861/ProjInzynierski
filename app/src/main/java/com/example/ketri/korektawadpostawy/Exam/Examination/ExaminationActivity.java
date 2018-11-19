package com.example.ketri.korektawadpostawy.Exam.Examination;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ketri.korektawadpostawy.BackArrowToHome;
import com.example.ketri.korektawadpostawy.Exam.Item;
import com.example.ketri.korektawadpostawy.Exam.Results.ResultActivity;
import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.Exercises.activities.ExerciseActivity;
import com.example.ketri.korektawadpostawy.Home.activity.InfoActivity;
import com.example.ketri.korektawadpostawy.R;
import com.github.xizzhu.simpletooltip.ToolTip;
import com.github.xizzhu.simpletooltip.ToolTipView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExaminationActivity extends AppCompatActivity implements BackArrowToHome{
    @BindView(R.id.ExamViewPager)
    ViewPager viewPager;

    @BindView(R.id.nameCardView)
    TextView nameCardView;

    DataBaseHelper myDb;
    Adapter adapter;
    List<Item> items;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @BindView(R.id.btn_gotoresult)
    Button btn_gotoresult;

    Button btn_info;


    @OnClick(R.id.btn_gotoresult)
    void onClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination);
        ButterKnife.bind(this);
        SupportActionBarBack();
        findViewById(R.id.btn_info).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ToolTip toolTip = new ToolTip.Builder()
                .withText("Jeżeli posiadasz wadę przedstawioną po prawej stronie, naciśnij czerwony przycisk.")
                .withTextSize(50)
                .withTextColor(Color.BLACK)
                .withBackgroundColor(Color.TRANSPARENT)
                .withCornerRadius(20f)
                .withPadding(50,0,0,0)
                .build();
        ToolTipView toolTipView = new ToolTipView.Builder(ExaminationActivity.this)
                .withAnchor(v)
                .withToolTip(toolTip)
                .withGravity(Gravity.LEFT)
                .build();
        toolTipView.show();
    }
});
        myDb = new DataBaseHelper(this);
        items = new ArrayList<>();
        items.add(new Item(R.drawable.scoliosisexamin, "Skolioza", "Sprawdź czy linia barkowa, łączy oba wyrostki barkowe. Czy linia sutkowa jest równa?    "));
        items.add(new Item(R.drawable.kyphosisexam, "Kifoza", "Czy głowa i szyja jest wysunięta? Czy łopatki odstają poza kontur pleców?     "));
        items.add(new Item(R.drawable.lordosisexam, "Lordoza", "Czy zarys brzucha wystaje poza linię klatki piersiowej. Czy kręgosłup jest nienaturalnie wygięty w stronę brzuszną?"));
        items.add(new Item(R.drawable.flatexamin, "Plecy płaskie", "Sprawdź czy zarys klatki piersiowej jest płaski.        "));
        items.add(new Item(R.drawable.roundexam, "Plecy okrągło-wkęsłe", "Czy łopatki odstają poza kontur pleców? Sprawdź czy zarys brzucha wystaje poza linię klatki piersiowej."));

        adapter = new Adapter(items, this);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);
        Integer[] colors_temp =
                {getResources().getColor(R.color.color1),
                        getResources().getColor(R.color.color2),
                        getResources().getColor(R.color.color3),
                        getResources().getColor(R.color.color4),
                        getResources().getColor(R.color.color5)
                };
        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length) - 1) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        Bundle data = getIntent().getExtras();
        String totext = data.getString("nameCardView");
        nameCardView.setText(totext);

        if (nameCardView.getText().toString().contains("Skolioza")) {
            boolean isInserted = myDb.insertData(0, null, nameCardView.getText().toString());
            if (isInserted == true)
                Toast.makeText(this, R.string.Data_Inserted, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, R.string.Data_not_Inserted, Toast.LENGTH_LONG).show();
        }
        if (nameCardView.getText().toString().contains("Kifoza")) {
            boolean isInserted = myDb.insertData(0, null, nameCardView.getText().toString());
            if (isInserted == true)
                Toast.makeText(this, R.string.Data_Inserted, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, R.string.Data_not_Inserted, Toast.LENGTH_LONG).show();
        }
        if (nameCardView.getText().toString().contains("Lordoza")) {
            boolean isInserted = myDb.insertData(0, null, nameCardView.getText().toString());
            if (isInserted == true)
                Toast.makeText(this, R.string.Data_Inserted, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, R.string.Data_not_Inserted, Toast.LENGTH_LONG).show();
        }
        if (nameCardView.getText().toString().contains("Plecy płaskie")) {
            boolean isInserted = myDb.insertData(0, null, nameCardView.getText().toString());
            if (isInserted == true)
                Toast.makeText(this, R.string.Data_Inserted, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, R.string.Data_not_Inserted, Toast.LENGTH_LONG).show();
        }
        if (nameCardView.getText().toString().contains("Plecy okrągło-wkęsłe")) {
            boolean isInserted = myDb.insertData(0, null, nameCardView.getText().toString());
            if (isInserted == true)
                Toast.makeText(this, R.string.Data_Inserted, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, R.string.Data_not_Inserted, Toast.LENGTH_LONG).show();
        }
    }

    private void insertDefect() {
        boolean isInserted = myDb.insertData(0, null, nameCardView.getText().toString());
        if (isInserted == true)
            Toast.makeText(this, R.string.Data_Inserted, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, R.string.Data_not_Inserted, Toast.LENGTH_LONG).show();
    }
    @Override
    public void SupportActionBarBack() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
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
