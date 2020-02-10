package edu.uci.swe264p.retrofit;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MovieListActivity extends AppCompatActivity implements TopRatedResponse.OnTopRatedMovieUpdateCallback {
    private RecyclerView recyclerView;
    private MovieListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        TopRatedResponse response = new TopRatedResponse();
        response.setCallback(this);
        Log.e("xxx", "1");
        response.connect();
        Log.e("xxx", "2");


        recyclerView = findViewById(R.id.rvMovieList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MovieListAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onMovieUpdate(MovieList movieList) {
        adapter.setMovies(movieList.getMovies());
        adapter.notifyDataSetChanged();
    }
}
