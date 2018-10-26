package com.example.ketri.korektawadpostawy.Exam;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ketri.korektawadpostawy.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {

    private Questions questions=new Questions();
    private int QuestionLength=questions.Questions.length;
    Random r;
    private String defect;

    @BindView(R.id.question)
    TextView question;

    @BindView(R.id.answer1)
    Button answer1;

    @BindView(R.id.answer2)
    Button answer2;

    @BindView(R.id.answer3)
    Button answer3;

    @OnClick(R.id.answer1)
    void onClick1(View view) {
        updateQuestion(r.nextInt(QuestionLength));
    }

    @OnClick(R.id.answer2)
    void onClick2(View view) {
        updateQuestion(r.nextInt(QuestionLength));
    }

    @OnClick(R.id.answer3)
    void onClick3(View view) {
        if(question.getText() == "Skrzywienie boczne kręgosłupa:")
        {
            defect = "skolioza";
            info();
            updateQuestion(r.nextInt(QuestionLength));
        }
        if(question.getText() == "Ustawienie głowy:")
        {
            defect ="kifoza";
            info();
            updateQuestion(r.nextInt(QuestionLength));

        }
        if(question.getText() == "Ustawienie barków:")
        {
            defect ="plecy okrągło-wklęsłe";
            info();
            updateQuestion(r.nextInt(QuestionLength));

        }

        if(question.getText() == "Ustawienie i kształt klatki piersiowej:")
        {
            defect ="plecy płaskie";
            info();
            updateQuestion(r.nextInt(QuestionLength));

        }
        if(question.getText() == "Ustawienie łopatek:")
        {
            defect ="plecy okrągło-wklęsłe lub kifoza";
            info();
            updateQuestion(r.nextInt(QuestionLength));

        }
        if(question.getText() == "Ustawienie brzucha:")
        {
            defect ="lordoza";
            info();
            updateQuestion(r.nextInt(QuestionLength));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        r=new Random();
        updateQuestion(r.nextInt(QuestionLength));
        SupportActionBarBack();


    }

    private void updateQuestion ( int num){
        question.setText(questions.getQuestion(num));
        answer1.setText(questions.getChoice1(num));
        answer2.setText(questions.getChoice2(num));
        answer3.setText(questions.getChoice3(num));
    }
    private void info(){
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestActivity.this);
        alertDialogBuilder
                .setMessage("Prawdopodobna wada postawy to: "+defect+". Skonsultuj to z lekarzem!")
                .setCancelable(false)
                .setTitle("UWAGA")
                .setNegativeButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    closeOptionsMenu();
                    }
                });

        final AlertDialog alertDialog = alertDialogBuilder.create();
       alertDialog.setOnShowListener( new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            }
        });
        alertDialog.show();
    }
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
