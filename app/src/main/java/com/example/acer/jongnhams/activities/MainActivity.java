package com.example.acer.jongnhams.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.acer.jongnhams.R;
import com.example.acer.jongnhams.adapters.RecyclerViewAdapter;
import com.example.acer.jongnhams.model.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://getandroiddata.000webhostapp.com/";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Anime> animeList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animeList = new ArrayList<>();

        recyclerView = findViewById(R.id.recylerViewid);
        jsonRequest();
    }

    private void jsonRequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for (int i=0; i< response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Anime anime = new Anime();
                        anime.setName(jsonObject.getString("food_name"));
                        anime.setDiscount(jsonObject.getString("food_disc"));
                        anime.setImage_url(jsonObject.getString("food_img"));

                        animeList.add(anime);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setupRecyclerview(animeList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setupRecyclerview(List<Anime> animeList) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, animeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }
}
