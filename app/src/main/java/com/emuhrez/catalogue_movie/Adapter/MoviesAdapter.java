package com.emuhrez.catalogue_movie.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.emuhrez.catalogue_movie.Model.MoviesModel;
import com.emuhrez.catalogue_movie.R;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MoviesModel> listMovie;

    private ArrayList<MoviesModel> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<MoviesModel> listMovie) {
        this.listMovie = listMovie;
    }

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movies, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.movieTitle.setText(getListMovie().get(i).getMoviesTitle());
        viewHolder.movieOverview.setText(getListMovie().get(i).getMoviesOverview());
        Glide.with(context)
                .load(getListMovie().get(i).getMoviesPoster())
                .into(viewHolder.moviePoster);

    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;
        TextView movieOverview;
        ImageView moviePoster;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.id_movies_title);
            movieOverview = itemView.findViewById(R.id.id_movies_description);
            moviePoster = itemView.findViewById(R.id.id_movies_poster);
        }

    }
}
