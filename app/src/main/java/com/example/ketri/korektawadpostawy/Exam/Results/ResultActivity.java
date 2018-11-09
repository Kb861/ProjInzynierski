package com.example.ketri.korektawadpostawy.Exam.Results;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.txv_result)
    TextView txv_result;

    @BindView(R.id.txv_resultres)
    TextView txv_resultres;

    @BindView(R.id.txv_resultkif)
    TextView txv_resultkif;

    @BindView(R.id.txv_resultres2)
    TextView txv_resultres2;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        myDb=new DataBaseHelper(this);



        txv_result.setText(String.valueOf(myDb.getDefect()));
        if(txv_result.getText().toString().contains("Skolioza")){

           txv_resultres.setText("Prawdopodobnie masz skoliozę");
      }
        txv_resultkif.setText(String.valueOf(myDb.getDefectKif()));
        if(txv_resultkif.getText().toString().contains("Kifoza")){

            txv_resultres2.setText("Prawdopodobnie masz kifozę");
        }





    }
}
