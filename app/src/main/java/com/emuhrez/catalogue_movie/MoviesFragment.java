package com.emuhrez.catalogue_movie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emuhrez.catalogue_movie.Adapter.MoviesAdapter;
import com.emuhrez.catalogue_movie.Model.MoviesModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private RecyclerView recyclerViewMovies;
    private ArrayList<MoviesModel> listMovies = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerViewMovies = rootView.findViewById(R.id.rv_movies);
        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initialization();
        showListMovies();
    }

    private void showListMovies(){
        recyclerViewMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        MoviesAdapter moviesAdapter = new MoviesAdapter(getContext());
        moviesAdapter.setListMovie(listMovies);
        recyclerViewMovies.setAdapter(moviesAdapter);

        ItemSupport.addTo(recyclerViewMovies).setOnItemClickListener(new ItemSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent movieDetail = new Intent(getContext(), DetailsMoviesActivity.class);
                movieDetail.putExtra(DetailsMoviesActivity.DETAIL_MOVIE, listMovies.get(position));
                startActivity(movieDetail);
            }
        });
    }

    private void initialization() {
        String[] moviesTitle = getResources().getStringArray(R.array.movies_title);
        String[] moviesRelease = getResources().getStringArray(R.array.movies_release);
        String[] moviesVote = getResources().getStringArray(R.array.movies_vote);
        String[] moviesOverview = getResources().getStringArray(R.array.movies_overview);
        @SuppressLint("Recycle") TypedArray moviesImage = getResources().obtainTypedArray(R.array.movies_poster);

        for (int i = 0; i < moviesTitle.length; i++) {
            MoviesModel movieModel = new MoviesModel();
            movieModel.setMoviesTitle(moviesTitle[i]);
            movieModel.setMoviesReleasedDate(moviesRelease[i]);
            movieModel.setMoviesVote(Double.valueOf(moviesVote[i]));
            movieModel.setMoviesOverview(moviesOverview[i]);
            movieModel.setMoviesPoster(moviesImage.getResourceId(i, -1));
            listMovies.add(movieModel);
        }
    }
}
