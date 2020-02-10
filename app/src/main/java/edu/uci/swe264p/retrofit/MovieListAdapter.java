package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder>{
    private List<Movie> movies;

    MovieListAdapter(MovieList movieList){
        this.movies = movieList.getMovies();
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
    public MovieListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(movies.get(position).getTitle());
        holder.releaseDate.setText(movies.get(position).getReleaseDate());
        holder.vote.setText(movies.get(position).getVoteAverage().toString());
        holder.overview.setText(movies.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

}
