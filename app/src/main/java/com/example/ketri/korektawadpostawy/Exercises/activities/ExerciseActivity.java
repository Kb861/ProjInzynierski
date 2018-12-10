package com.example.ketri.korektawadpostawy.Exercises.activities;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
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

    @BindView(R.id.et_repeat)
    EditText et_repeat;

    @BindView(R.id.btn_ok)
    Button btn_done;

    @BindView(R.id.btn_succes)
    Button btn_mySuccess;

    DataBaseHelper myDb;
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
        videoView.setTag(video);

        collapsingToolbarLayout.setTitle(name);
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        Glide.with(this).load(image_url).apply(requestOptions).into(img);


        int id = this.getResources().getIdentifier(video.replace(".mp4",""), "raw", this.getPackageName());
        String videoPath="android.resource://" + getPackageName() + "/" + id;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0,0);
            }
        });
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
        myDb=new DataBaseHelper(this);
            viewAll();
            AddData();
    }
    public void AddData() {
        btn_done.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                        boolean isInserted = myDb.insertData(Integer.parseInt(et_repeat.getText().toString()),tvRatingScale.getText().toString(),null);
                        if(isInserted == true)
                            Toast.makeText(ExerciseActivity.this, R.string.Data_Inserted ,Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(ExerciseActivity.this,R.string.Data_not_Inserted,Toast.LENGTH_LONG).show();
                        }catch(Exception e)
                        { Toast.makeText(ExerciseActivity.this,R.string.Data_error,Toast.LENGTH_LONG).show(); }
                    }
                }
        );
    }
    public void viewAll() {
        btn_mySuccess.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Brak danych");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Data: " + res.getString(1) + "\n");
                            buffer.append("Punkty: " + res.getString(2) + "\n");
                            buffer.append("Nasrój: " + res.getString(3) + "\n");
                        }
                        showMessage("Dane", buffer.toString());
                     }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
