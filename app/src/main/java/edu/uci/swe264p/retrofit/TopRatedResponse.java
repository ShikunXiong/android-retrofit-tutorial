package edu.uci.swe264p.retrofit;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopRatedResponse {
    static Retrofit retrofit = null;
    static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    final static String API_KEY = "035917615d522300f90bc9cef1cc3ecc";

    private MovieList movieList = null;

    private OnTopRatedMovieUpdateCallback callback;
    public void setCallback(OnTopRatedMovieUpdateCallback callback) {
        this.callback = callback;
    }

    public MovieList getMovieList() {
        Log.e("xxx", "2yes");
        return movieList;
    }

    public void connect() {
        Log.e("xxx", "connect");
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        MovieApiService movieApiService = retrofit.create(MovieApiService.class);
        Call<MovieList> call = movieApiService.getTopMovies(API_KEY);
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                assert response.body() != null;
                movieList = new MovieList(response.body().getMovies());
                Log.e("xxx", "1yes");

                if (callback != null) {
                    callback.onMovieUpdate(movieList);
                }
            }
            @Override
            public void onFailure(Call<MovieList> call, Throwable throwable) {
                Log.e("xxx", "fail");
            }
        });
    }

    public interface OnTopRatedMovieUpdateCallback {
        void onMovieUpdate(MovieList movieList);
    }
}
