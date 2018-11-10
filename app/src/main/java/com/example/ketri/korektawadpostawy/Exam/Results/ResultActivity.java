package com.example.ketri.korektawadpostawy.Exam.Results;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ketri.korektawadpostawy.Exam.Results.Result.Result;
import com.example.ketri.korektawadpostawy.Exam.Results.Result.ResultAdapter;
import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.recyclerExam)
    RecyclerView recycler;

    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        myDb=new DataBaseHelper(this);

        ArrayList<Result> results =new ArrayList<>();
        results.add(new Result("Skolioza", "Prawdopodobnie posiadasz skoliozę. Skonsultuj się z lekarzem."));
        results.add(new Result("Kifoza", "Prawdopodobnie posiadasz kifozę. Skonsultuj się z lekarzem."));
        results.add(new Result("Lordoza", "Prawdopodobnie posiadasz lordozę. Skonsultuj się z lekarzem."));
        results.add(new Result("Plecy płaskie", "Prawdopodobnie posiadasz plecy płaskie. Skonsultuj się z lekarzem."));
        results.add(new Result("Plecy okrągło-wklęsłe", "Prawdopodobnie posiadasz plecy okrągło-wklęsłe. Skonsultuj się z lekarzem."));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);

        ResultAdapter resultAdaper = new ResultAdapter(results);
        recycler.setAdapter(resultAdaper);



    }
}
