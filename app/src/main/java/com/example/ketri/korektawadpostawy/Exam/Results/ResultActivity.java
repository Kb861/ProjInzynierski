package com.example.ketri.korektawadpostawy.Exam.Results;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.ketri.korektawadpostawy.BackArrowToHome;
import com.example.ketri.korektawadpostawy.Exam.Results.Result.Result;
import com.example.ketri.korektawadpostawy.Exam.Results.Result.ResultAdapter;
import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.Exercises.model.Defect;
import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity implements BackArrowToHome {

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
        results.add(new Result("Skolioza", null));
        results.add(new Result("Kifoza", null));
        results.add(new Result("Lordoza", null));
        results.add(new Result("Plecy płaskie", null));
        results.add(new Result("Plecy okrągło-wklęsłe", null));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);

        ResultAdapter resultAdapter = new ResultAdapter(results);
        recycler.setAdapter(resultAdapter);
        SupportActionBarBack();
        myDb=new DataBaseHelper(this);
        defectsList =new ArrayList<>();

        defectsList.addAll(myDb.getListDefect());
        for(int i = 0;i<defectsList.size();i++)
        {
                if (defectsList.get(i).getName().equals("Skolioza")) {
                    results.set(0, (new Result("Skolioza", "Prawdopodobnie posiadasz skoliozę. Skonsultuj się z lekarzem.")));}
                if (defectsList.get(i).getName().equals("Kifoza")) {
                    results.set(1, (new Result("Kifoza", "Prawdopodobnie posiadasz kifozę. Skonsultuj się z lekarzem.")));}
                if (defectsList.get(i).getName().equals("Lordoza")) {
                    results.set(2, (new Result("Lordoza", "Prawdopodobnie posiadasz lordozę. Skonsultuj się z lekarzem.")));}
                if (defectsList.get(i).getName().equals("Plecy płaskie")) {
                results.set(3, (new Result("Plecy płaskie", "Prawdopodobnie posiadasz plecy płaskie. Skonsultuj się z lekarzem.")));}
                if (defectsList.get(i).getName().equals("Plecy okrągło-wklęsłe")) {
                results.set(4, (new Result("Plecy okrągło-wklęsłe", "Prawdopodobnie posiadasz plecy okrągło-wklęsłe. Skonsultuj się z lekarzem.")));}
        }

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
