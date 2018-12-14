package com.example.ketri.korektawadpostawy.AboutApp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.ketri.korektawadpostawy.MainActivity;
import com.example.ketri.korektawadpostawy.R;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class AboutAppActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPrevText(this.getResources().getString(R.string.back));
        setNextText(this.getResources().getString(R.string.next));
        setFinishText(this.getResources().getString(R.string.finish));
        setCancelText(this.getResources().getString(R.string.cancel));
        addFragment(new Step.Builder().setTitle(this.getResources().getString(R.string.aboutapp1))
                .setContent(this.getResources().getString(R.string.aboutapp2))
                .setBackgroundColor(Color.parseColor("#01579B"))
                .setDrawable(R.drawable.pain)
                .build());
        addFragment(new Step.Builder().setTitle(this.getResources().getString(R.string.aboutapp3))
                .setContent(this.getResources().getString(R.string.aboutapp4))
                .setBackgroundColor(Color.parseColor("#C62828"))
                .setDrawable(R.drawable.men)
                .build());
        addFragment(new Step.Builder().setTitle(this.getResources().getString(R.string.aboutapp5))
                .setContent(this.getResources().getString(R.string.aboutapp6))
                .setBackgroundColor(Color.parseColor("#FFC107"))
                .setDrawable(R.drawable.badge)
                .build());
        addFragment(new Step.Builder().setTitle(this.getResources().getString(R.string.aboutapp7))
                .setContent(this.getResources().getString(R.string.aboutapp8))
                .setBackgroundColor(Color.parseColor("#FFCDD2"))
                .setDrawable(R.drawable.happy)
                .build());
    }
    @Override
    public void finishTutorial() {
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
