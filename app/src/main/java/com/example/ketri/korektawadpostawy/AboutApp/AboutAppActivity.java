package com.example.ketri.korektawadpostawy.AboutApp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ketri.korektawadpostawy.R;
import com.hololo.tutorial.library.PermissionStep;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class AboutAppActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPrevText("Wróć");
        setNextText("Dalej");
        setFinishText("Koniec");
        setCancelText("Anuluj");
        addFragment(new Step.Builder().setTitle("Jeżeli posiadasz wadę postawy")
                .setContent("lub chcesz dbać o swój kręgosłup to ta aplikacja jest właśnie dla Ciebie!")
                .setBackgroundColor(Color.parseColor("#01579B"))
                .setDrawable(R.drawable.pain)
                .setSummary("to...")
                .build());
        addFragment(new Step.Builder().setTitle("Ta aplikacja jest właśnie dla Ciebie!")
                .setContent("Poświęć swój czas na zmianę na lepsze")
                .setBackgroundColor(Color.parseColor("#C62828"))
                .setDrawable(R.drawable.clock)
                .build());
        addFragment(new Step.Builder().setTitle("Zbierz trzy odznaki")
                .setContent("i zostań mistrzem ćwiczeń.")
                .setBackgroundColor(Color.parseColor("#FFC107"))
                .setDrawable(R.drawable.badge)
                .build());
        addFragment(new Step.Builder().setTitle("Następnie ciesz się zdrowym kręgosłupem.")
                .setContent("Zacznij już dziś.")
                .setBackgroundColor(Color.parseColor("#FFCDD2"))
                .setDrawable(R.drawable.happy)
                .build());


    }

}
