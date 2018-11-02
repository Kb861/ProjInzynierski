package com.example.ketri.korektawadpostawy.Exam.Results;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.txv_result)
    TextView txv_result ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        Bundle przekazanedane = getIntent().getExtras();

        String przekazanytekst = przekazanedane.getString("slowa");

        txv_result.setText(przekazanytekst);





    }
}
