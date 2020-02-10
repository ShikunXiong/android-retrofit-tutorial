package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder>{
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    private List<Movie> movies;
    private String IMAGE_URL_BASE = "https://image.tmdb.org/t/p/w500/";

    MovieListAdapter(List<Movie> movies){
        this.movies = movies;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView releaseDate;
        TextView vote;
        TextView overview;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivMovie);
            title = itemView.findViewById(R.id.tvTitle);
            releaseDate = itemView.findViewById(R.id.tvReleaseDate);
            vote = itemView.findViewById(R.id.tvVote);
            overview = itemView.findViewById(R.id.tvOverview);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(movies.get(position).getTitle());
        holder.releaseDate.setText(movies.get(position).getReleaseDate());
        holder.vote.setText(movies.get(position).getVoteAverage().toString());
        holder.overview.setText(movies.get(position).getOverview());

        Picasso.get().load(IMAGE_URL_BASE + movies.get(position).getPosterPath()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

}
