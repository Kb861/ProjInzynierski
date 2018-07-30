package com.example.ketri.korektawadpostawy.Exercises.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.ketri.korektawadpostawy.R;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        getSupportActionBar().hide();


        // Recieve data
        String name  = getIntent().getExtras().getString("anime_name");

        String description = getIntent().getExtras().getString("anime_description");



        String category = getIntent().getExtras().getString("anime_category");

        int nb_episode = getIntent().getExtras().getInt("anime_nb_episode") ;

        String rating = getIntent().getExtras().getString("anime_rating") ;


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);

        collapsingToolbarLayout.setTitleEnabled(true);



        TextView tv_name = findViewById(R.id.aa_anime_name);



        TextView tv_categorie = findViewById(R.id.aa_categorie) ;

        TextView tv_description = findViewById(R.id.aa_description);

        TextView tv_rating  = findViewById(R.id.aa_rating) ;





        // setting values to each view



        tv_name.setText(name);

        tv_categorie.setText(category);

        tv_description.setText(description);

        tv_rating.setText(rating);





        collapsingToolbarLayout.setTitle(name);





        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.spine).error(R.drawable.spine);
    }
}
