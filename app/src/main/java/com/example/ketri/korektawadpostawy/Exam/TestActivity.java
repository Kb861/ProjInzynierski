package com.example.ketri.korektawadpostawy.Exam;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private  String defect;

    @BindView(R.id.score)
    TextView score;

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
            defect ="skolioza";
           // score.setText("Prawdopodona skolioza");
            info();
            updateQuestion(r.nextInt(QuestionLength));

        }
        if(question.getText() == "Ustawienie głowy:")
        {
            score.setText("Prawdopodona kifoza");
            updateQuestion(r.nextInt(QuestionLength));

        }
        if(question.getText() == "Ustawienie barków:")
        {
            score.setText("Prawdopodona ow");
            updateQuestion(r.nextInt(QuestionLength));

        }

        if(question.getText() == "Ustawienie i kształt klatki piersiowej:")
        {
            score.setText("Prawdopodona plaskie");
            updateQuestion(r.nextInt(QuestionLength));

        }
        if(question.getText() == "Ustawienie łopatek:")
        {
            score.setText("Prawdopodona kifoza lub ow.");
            updateQuestion(r.nextInt(QuestionLength));

        }
        if(question.getText() == "Ustawienie brzucha:")
        {
            score.setText("Prawdopodona lordoza");
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

    }



        private void updateQuestion ( int num){
        question.setText(questions.getQuestion(num));
        answer1.setText(questions.getChoice1(num));
        answer2.setText(questions.getChoice2(num));
        answer3.setText(questions.getChoice3(num));

    }
    private void info(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestActivity.this);
        alertDialogBuilder
                .setMessage("Prawdopodobna wada postawy to:"+defect+"Idz do lekarza!")
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    closeOptionsMenu();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
