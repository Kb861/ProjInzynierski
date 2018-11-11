package com.example.ketri.korektawadpostawy.Exam.Results;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ketri.korektawadpostawy.Exam.Results.Result.Result;
import com.example.ketri.korektawadpostawy.Exam.Results.Result.ResultAdapter;
import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.Exercises.model.Defect;
import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.recyclerExam)
    RecyclerView recycler;
    public ArrayList<Defect> defectsList;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        myDb=new DataBaseHelper(this);

        ArrayList<Result> results =new ArrayList<>();
        results.add(new Result("Skolioza", "Prawdopodobnie posiadasz skoliozę. Skonsultuj się z lekarzem.","cos"));
        results.add(new Result("Kifoza", "Prawdopodobnie posiadasz kifozę. Skonsultuj się z lekarzem.","masz wadę"));
        results.add(new Result("Lordoza", "Prawdopodobnie posiadasz lordozę. Skonsultuj się z lekarzem.","masz wadę"));
        results.add(new Result("Plecy płaskie", "Prawdopodobnie posiadasz plecy płaskie. Skonsultuj się z lekarzem.","masz wadę"));
        results.add(new Result("Plecy okrągło-wklęsłe", "Prawdopodobnie posiadasz plecy okrągło-wklęsłe. Skonsultuj się z lekarzem.","masz wadę"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);

        ResultAdapter resultAdaper = new ResultAdapter(results);
        recycler.setAdapter(resultAdaper);

        myDb=new DataBaseHelper(this);
        defectsList =new ArrayList<>();

        defectsList.addAll(myDb.getDefect());
        for(int i =0;i<defectsList.size();i++)
        {

            if(defectsList.get(i).getName().equals("Skolioza")){ results.set(0, (new Result("heloo", "Prawdopodobnie posiadasz skoliozę. Skonsultuj się z lekarzem.","cos")));}
            if(defectsList.get(i).getName().equals("Kifoza")){ results.set(1, (new Result("heloo11", "Prawdopodobnie posiadasz skoliozę. Skonsultuj się z lekarzem.","cos")));}
            if(defectsList.get(i).getName().equals("Lordoza")){ results.set(2, (new Result("heloo22", "Prawdopodobnie posiadasz skoliozę. Skonsultuj się z lekarzem.","cos")));}
        }

    }
}
