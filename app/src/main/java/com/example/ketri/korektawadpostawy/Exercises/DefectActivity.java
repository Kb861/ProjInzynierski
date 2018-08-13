package com.example.ketri.korektawadpostawy.Exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.widget.Toast;

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

public class DefectActivity extends AppCompatActivity {

    public String URL_JSON;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<ExerciseModel> lstAnime;
    private RecyclerView recyclerView ;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect);
        recyclerView = findViewById(R.id.recyclerV);
       name=findViewById(R.id.name);

        Bundle przekazanedane = getIntent().getExtras();
        String przekazanytekst = przekazanedane.getString("KEY");
        name.setText(przekazanytekst);


        if(name.getText().toString().contains("Skolioza"))
      {

          //innyTXT.setText(napis);
         URL_JSON = "https://gist.githubusercontent.com/Kb861/64f437511467d024a7e981022bbc0ef6/raw/40f9283f96735e9d197345c470fefde841ba89ef/skoliosis.json";
          lstAnime=new ArrayList<>();
          jsoncall();

      }
        if(name.getText().toString().contains("Kifoza"))
        {

            //innyTXT.setText(napis);
            URL_JSON = "https://gist.githubusercontent.com/Kb861/88fc23e1e50bf92048cb3004e5e9a473/raw/3058707395ceeaf261bc205dc517bf8208143d9f/kyphosis.json";
            lstAnime=new ArrayList<>();
            jsoncall();

        }






    }
    public void jsoncall() {





       request = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {

            @Override

            public void onResponse(JSONArray response) {



                JSONObject jsonObject = null;





                for (int i = 0 ; i<response.length();i++) {



                    //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();



                    try {



                        jsonObject = response.getJSONObject(i);

                        ExerciseModel anime = new ExerciseModel();

                        anime.setName(jsonObject.getString("name"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setCategorie(jsonObject.getString("categorie"));
                        anime.setNb_episode(jsonObject.getInt("episode"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setImage_url(jsonObject.getString("img"));






                        //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();

                        lstAnime.add(anime);

                    }

                    catch (JSONException e) {

                        e.printStackTrace();

                    }

                }





                Toast.makeText(DefectActivity.this,"Size of Liste "+String.valueOf(lstAnime.size()),Toast.LENGTH_SHORT).show();

                Toast.makeText(DefectActivity.this,lstAnime.get(1).toString(),Toast.LENGTH_SHORT).show();



                setRecyclerViewAdapter(lstAnime);

            }

        }, new Response.ErrorListener() {

            @Override

            public void onErrorResponse(VolleyError error) {



            }

        });





        requestQueue = Volley.newRequestQueue(DefectActivity.this);

        requestQueue.add(request);

    }

    public void setRecyclerViewAdapter(List<ExerciseModel> lstAnime) {
        RecyclerViewAdapter myAdapter = new  RecyclerViewAdapter(this,lstAnime) ;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapter);
    }






}
