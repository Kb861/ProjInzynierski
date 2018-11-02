package com.example.ketri.korektawadpostawy.Exam.Examination;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ketri.korektawadpostawy.Exam.Item;
import com.example.ketri.korektawadpostawy.Exam.Results.ResultActivity;
import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExaminationActivity extends AppCompatActivity {
    @BindView(R.id.ExamViewPager)
     ViewPager viewPager;

    @BindView(R.id.name)
    TextView name;
String place;
    Adapter adapter;
    List<Item>items;
    Integer[]colors=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    @BindView(R.id.btn)
    Button btn;

    String wpisanyTekst = "Prawdopodobni mozesz miec skolioze";
//    @OnClick(R.id.btn)
//    void onClick2(View view){
//        if(adapter.get(0))) {
//
//            Intent intent = new Intent(ExaminationActivity.this, ResultActivity.class);
//
//            Bundle bundle = new Bundle();
//
//
//            bundle.putString("KEY", wpisanyTekst);
//
//            intent.putExtras(bundle);
//
//            startActivity(intent);
//
//        }

   // }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination);
        ButterKnife.bind(this);
        items=new ArrayList<>();
        items.add(new Item(R.drawable.clock,"Tytuł 1","Opis1"));
        items.add(new Item(R.drawable.doctor,"Tytuł 2","Opis2"));
        items.add(new Item(R.drawable.happy,"Tytuł 3","Opis3"));

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(items.get(v).getCardName()){
//
//                }
//            }
//        });

        OnItemClick listener = (view, position) -> {

            place = items.get(position).getDescrip();

            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

            Bundle bundle = new Bundle();

            bundle.putString("Nazwa", place);

            intent.putExtras(bundle);

            startActivity(intent);

        };
        adapter=new Adapter(items,this);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);
        Integer[]colors_temp=
                {getResources().getColor(R.color.color1),
                        getResources().getColor(R.color.color2),
                        getResources().getColor(R.color.color3)

                };
colors=colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<(adapter.getCount() - 1)&& position<(colors.length)-1){
                   viewPager.setBackgroundColor((Integer)argbEvaluator.evaluate(positionOffset,colors[position],colors[position+1]));
                }else {viewPager.setBackgroundColor(colors[colors.length-1]);}
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        Bundle data = getIntent().getExtras();
        String totext = data.getString("KEY");
        name.setText(totext);

        if(name.getText().toString().contains("Tytuł 1")) {





            String wpisanyTekst = "Prawdopodobni mozesz miec skolioze";
            Bundle bundle = new Bundle();

            bundle.putString("slowa", wpisanyTekst);
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Masz skolioze! Ale spr to",
                    Toast.LENGTH_LONG).show();

        }
        if(name.getText().toString().contains("Tytuł 2")) {

            Intent intent = new Intent(ExaminationActivity.this, ResultActivity.class);

            Bundle bundle = new Bundle();

            String wpisanyTekst = "Prawdopodobni mozesz miec kifoze";

            bundle.putString("slowa", wpisanyTekst);

            intent.putExtras(bundle);

            startActivity(intent);

        }
    }
}
