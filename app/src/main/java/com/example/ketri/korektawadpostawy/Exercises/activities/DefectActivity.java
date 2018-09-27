package com.example.ketri.korektawadpostawy.Exercises.activities;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ketri.korektawadpostawy.Exercises.adapters.RecyclerViewAdapter;
import com.example.ketri.korektawadpostawy.Exercises.model.ExerciseModel;
import com.example.ketri.korektawadpostawy.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DefectActivity extends AppCompatActivity {

    public String URL_JSON;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<ExerciseModel> lstEX;
    private RecyclerView recyclerView ;

    @BindView(R.id.name)
    TextView name;

    @Nullable
    @BindView(R.id.videoView)
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect);
        ButterKnife.bind(this);
        recyclerView = findViewById(R.id.recyclerV);

        Bundle data = getIntent().getExtras();
        String totext = data.getString("KEY");
        name.setText(totext);

        if(name.getText().toString().contains("Skolioza"))
      {
         URL_JSON = "https://gist.githubusercontent.com/Kb861/64f437511467d024a7e981022bbc0ef6/raw/38ab94ab429db94fdd5b70f4933dbcefcf3f974d/skoliosis.json";
          lstEX=new ArrayList<>();
          jsoncall();

      }
        if(name.getText().toString().contains("Kifoza"))
        {
            URL_JSON = "https://gist.githubusercontent.com/Kb861/88fc23e1e50bf92048cb3004e5e9a473/raw/a9efb8631956ed8b62021c1956d6fb21acd42bf0/kyphosis.json";
            lstEX=new ArrayList<>();
            jsoncall();

        }
        if(name.getText().toString().contains("Lordoza"))
        {
            URL_JSON = "https://gist.githubusercontent.com/Kb861/12be04f9392f48885f325d60dc996afb/raw/832f58f1b8c45a1225657833f6b67007379b3bbf/lordosis.json";
            lstEX=new ArrayList<>();
            jsoncall();

        }
        if(name.getText().toString().contains("Plecy płaskie"))
        {
            URL_JSON = "https://gist.githubusercontent.com/Kb861/055912258d7713697526f2df5310e975/raw/46b5010c283558a0b37e5807ec90b6d0786889dc/flat.json";
            lstEX=new ArrayList<>();
            jsoncall();

        }
        if(name.getText().toString().contains("Okrągło-wklęsłe"))
        {
            URL_JSON = "https://gist.githubusercontent.com/Kb861/178543f5895cb31e99f11d273371423a/raw/d370b857201491ef8bcc1953866f5ee28c9c265e/round.json";
            lstEX=new ArrayList<>();
            jsoncall();

        }
     SupportActionBar();
    }

    public void jsoncall() {

       request = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {

            @Override

            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0 ; i<response.length();i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        ExerciseModel ex = new ExerciseModel();

                        ex.setName(jsonObject.getString("name"));
                        ex.setDescription(jsonObject.getString("description"));
                        ex.setRating(jsonObject.getString("Rating"));
                        ex.setCategorie(jsonObject.getString("categorie"));
                        ex.setImage_url(jsonObject.getString("img"));
                        ex.setVideo(jsonObject.getString("video"));
                        lstEX.add(ex);
                    }
                    catch (JSONException e) {

                        e.printStackTrace();

                    }
                }
                setRecyclerViewAdapter(lstEX);

            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue = Volley.newRequestQueue(DefectActivity.this);
        requestQueue.add(request);

    }
    public void setRecyclerViewAdapter(List<ExerciseModel> lstEX) {
        RecyclerViewAdapter myAdapter = new  RecyclerViewAdapter(this,lstEX) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }

    public void SupportActionBar() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
