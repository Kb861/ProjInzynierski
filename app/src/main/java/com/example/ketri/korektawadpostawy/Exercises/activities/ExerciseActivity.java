package com.example.ketri.korektawadpostawy.Exercises.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExerciseActivity extends AppCompatActivity {
    @BindView(R.id.ex_name_view)
    TextView tv_name;

    @BindView(R.id.categorie_view)
    TextView tv_categorie;

    @BindView(R.id.rating_view)
    TextView tv_rating;

    @BindView(R.id.aa_studio)
    TextView tv_studio;

    @BindView(R.id.description_view)
    TextView tv_description;

    @BindView(R.id.thumbnail_view)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        // Recieve data
        String name  = getIntent().getExtras().getString("ex_name");
        String description = getIntent().getExtras().getString("ex_description");
        String studio = getIntent().getExtras().getString("ex_studio") ;
        String category = getIntent().getExtras().getString("ex_category");
        int nb_episode = getIntent().getExtras().getInt("ex_nb_episode") ;
        String rating = getIntent().getExtras().getString("ex_rating") ;
        String image_url = getIntent().getExtras().getString("ex_img") ;

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_studio.setText(studio);

        collapsingToolbarLayout.setTitle(name);
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        Glide.with(this).load(image_url).apply(requestOptions).into(img);

    }
}
