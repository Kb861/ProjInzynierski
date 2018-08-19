package com.example.ketri.korektawadpostawy.Exercises;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.MediaController;
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
         URL_JSON = "https://gist.githubusercontent.com/Kb861/64f437511467d024a7e981022bbc0ef6/raw/9841aa18f4494faeb45e8b0cf46322b5715074c0/skoliosis.json";
          lstEX=new ArrayList<>();
          jsoncall();

      }
        if(name.getText().toString().contains("Kifoza"))
        {
            URL_JSON = "https://gist.githubusercontent.com/Kb861/88fc23e1e50bf92048cb3004e5e9a473/raw/3058707395ceeaf261bc205dc517bf8208143d9f/kyphosis.json";
            lstEX=new ArrayList<>();
            jsoncall();

        }

//        if(name.getText().toString().contains("Lordoza"))
//        {
//
//            //innyTXT.setText(napis);
//            URL_JSON = "https://gist.githubusercontent.com/Kb861/68e5f88eb6a6a797c277d7795c2300d6/raw/2f8c5beeecf61b152f2943b2d5b45f58e40363c8/lordosis.json";
//            lstAnime=new ArrayList<>();
//            jsoncall();
//
//
//        }
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
                Toast.makeText(DefectActivity.this,"Size of Liste "+String.valueOf(lstEX.size()),Toast.LENGTH_SHORT).show();
                Toast.makeText(DefectActivity.this,lstEX.get(1).toString(),Toast.LENGTH_SHORT).show();
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






}
