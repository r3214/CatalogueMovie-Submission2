package com.emuhrez.catalogue_movie;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.emuhrez.catalogue_movie.Model.MoviesModel;

import java.util.Objects;

public class DetailsMoviesActivity extends AppCompatActivity {

    public static final String DETAIL_MOVIE = "detail_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movies);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        }

        TextView movieTitle = findViewById(R.id.id_movies_title_detail);
        TextView movieDate = findViewById(R.id.id_movies_release_detail);
        TextView movieVote = findViewById(R.id.id_movies_vote_detail);
        TextView movieOverview = findViewById(R.id.id_movies_overview_detail);
        ImageView moviePoster = findViewById(R.id.id_movies_poster_detail);

        MoviesModel movieDetail = getIntent().getParcelableExtra(DETAIL_MOVIE);

        movieTitle.setText(movieDetail.getMoviesTitle());
        movieDate.setText(movieDetail.getMoviesReleasedDate());
        movieOverview.setText(movieDetail.getMoviesOverview());
        movieVote.setText(String.valueOf(movieDetail.getMoviesVote()));
        Glide.with(this)
                .load(movieDetail.getMoviesPoster())
                .into(moviePoster);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
