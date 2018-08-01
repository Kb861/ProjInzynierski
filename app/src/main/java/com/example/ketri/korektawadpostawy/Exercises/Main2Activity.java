package com.example.ketri.korektawadpostawy.Exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.nowyTXT)
    TextView nowyTXT ;

    @BindView(R.id.innyTXT)
    TextView innyTXT ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
//
//        String napis="hej";
//        Bundle przekazanedane = getIntent().getExtras();
//        String przekazanytekst = przekazanedane.getString("KEY");
//        nowyTXT.setText(przekazanytekst);
//
//        if(nowyTXT.getText().toString().contains("Skolioza"))
//        {
//            innyTXT.setText(napis);
//        }

    }
}
