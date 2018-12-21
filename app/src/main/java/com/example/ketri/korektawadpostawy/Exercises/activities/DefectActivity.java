package com.example.ketri.korektawadpostawy.Exercises.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;
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

        Bundle datafromDefectAdapter = getIntent().getExtras();
        String textfromDefectAdapter = datafromDefectAdapter.getString("KEY");
        name.setText(textfromDefectAdapter);

        if(name.getText().toString().contains("Skolioza"))
      {
          URL_JSON = "https://gist.githubusercontent.com/Kb861/64f437511467d024a7e981022bbc0ef6/raw/3a789720ec42a24e9b0d3330f5e9253afcbdc477/skoliosis.json";
          lstEX=new ArrayList<>();
          jsoncall();
      }
        if(name.getText().toString().contains("Kifoza"))
        {
            URL_JSON = "https://gist.githubusercontent.com/Kb861/88fc23e1e50bf92048cb3004e5e9a473/raw/03ebd099cde7dd062f3806075d26181ea1380ab5/kyphosis.json";
            lstEX=new ArrayList<>();
            jsoncall();
        }
        if(name.getText().toString().contains("Lordoza"))
        {
            URL_JSON = "https://gist.githubusercontent.com/Kb861/12be04f9392f48885f325d60dc996afb/raw/8785c270cefc4c5b44b58b1ecec4c33decce6dd9/lordosis.json";
            lstEX=new ArrayList<>();
            jsoncall();
        }
        if(name.getText().toString().contains("Plecy płaskie"))
        {
            URL_JSON = "https://gist.githubusercontent.com/Kb861/055912258d7713697526f2df5310e975/raw/3f7e96ca7f60fed449214d7e47c71d5574330dc1/flat.json";
            lstEX=new ArrayList<>();
            jsoncall();
        }
        if(name.getText().toString().contains("Plecy okrągło-wklęsłe"))
        {
            URL_JSON = "https://gist.githubusercontent.com/Kb861/178543f5895cb31e99f11d273371423a/raw/07f95daafcaabf8882e1bc126b3fb2a41122cf0a/round.json";
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
