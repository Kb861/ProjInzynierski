package com.example.ketri.korektawadpostawy.Exam.Instruction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.ketri.korektawadpostawy.BackArrowToHome;
import com.example.ketri.korektawadpostawy.Exam.Examination.ExaminationActivity;
import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RulesActivity extends AppCompatActivity implements BackArrowToHome{

    @BindView(R.id.btn_goexam)
    Button btn_goexam;

    @OnClick(R.id.btn_goexam)
    void onClick(View view) {
        Intent intent = new Intent(this, ExaminationActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        ButterKnife.bind(this);
        SupportActionBarBack();
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
