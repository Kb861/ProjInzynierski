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
import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.Exercises.activities.ExerciseActivity;
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
    DataBaseHelper myDb;
    Adapter adapter;
    List<Item>items;
    Integer[]colors=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination);
        ButterKnife.bind(this);
       myDb=new DataBaseHelper(this);
        items=new ArrayList<>();
        items.add(new Item(R.drawable.scoliosisexamin,"Skolioza","Sprawdź czy linia barkowa, łączy oba wyrostki barkowe. Czy linia sutkowa jest równa?"));
        items.add(new Item(R.drawable.doctor,"Tytuł 2","Czy głowa i szyja jest wysunięta? Czy łopatki odstają poza kontur pleców?"));
        items.add(new Item(R.drawable.happy,"Tytuł 3","Czy zarys brzucha wystaje poza linię klatki piersiowej. Czy kręgosłup jest nienaturalnie wygięty w stronę brzuszną?"));
        items.add(new Item(R.drawable.scoliosisexamin,"Plaskie","Sprawdź czy zarys klatki piersiowej jest płaski."));
        items.add(new Item(R.drawable.scoliosisexamin,"OW","Czy łopatki odstają poza kontur pleców? Sprawdź czy zarys brzucha wystaje poza linię klatki piersiowej."));

        adapter=new Adapter(items,this);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);
        Integer[]colors_temp=
                {getResources().getColor(R.color.color1),
                        getResources().getColor(R.color.color2),
                        getResources().getColor(R.color.color3),
                        getResources().getColor(R.color.color4),
                        getResources().getColor(R.color.color5)

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

        if(name.getText().toString().contains("Skolioza")) {

            String wpisanyTekst = "Prawdopodobni mozesz miec skolioze";
            Bundle bundle = new Bundle();

            bundle.putString("slowa", wpisanyTekst);
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Masz skolioze! Ale spr to",
                    Toast.LENGTH_LONG).show();

            boolean isInserted = myDb.insertData(0,null,name.getText().toString());
            if(isInserted == true)
                Toast.makeText(ExaminationActivity.this, R.string.Data_Inserted ,Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ExaminationActivity.this,R.string.Data_not_Inserted,Toast.LENGTH_LONG).show();

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
