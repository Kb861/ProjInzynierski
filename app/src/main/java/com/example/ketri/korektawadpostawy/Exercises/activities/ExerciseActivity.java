package com.example.ketri.korektawadpostawy.Exercises.activities;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

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

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    @BindView(R.id.tvRatingScale)
    TextView tvRatingScale;

    @BindView(R.id.rating_view)
    TextView tv_rating;

    @BindView(R.id.description_view)
    TextView tv_description;

    @BindView(R.id.thumbnail_view)
    ImageView img;

    @BindView(R.id.videoView)
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        String name  = getIntent().getExtras().getString("exercise_name");
        String description = getIntent().getExtras().getString("ex_description");
        String category = getIntent().getExtras().getString("ex_category");
        String rating = getIntent().getExtras().getString("ex_rating") ;
        String image_url = getIntent().getExtras().getString("ex_img") ;
        String video = getIntent().getExtras().getString("ex_video") ;

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_description.setText(description);
        tv_rating.setText(rating);

        collapsingToolbarLayout.setTitle(name);
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        Glide.with(this).load(image_url).apply(requestOptions).into(img);

        String videoPath="/Users/ketri/repozytorium/ProjInzynierski/korektawadpostawy/app/src/main/res/raw/" + video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tvRatingScale.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        tvRatingScale.setText(R.string.bad);
                        break;
                    case 2:
                        tvRatingScale.setText(R.string.good);
                        break;
                    case 3:
                        tvRatingScale.setText(R.string.great);
                        break;
                    default:
                        tvRatingScale.setText("");

                }

            }

        });
    }
}
