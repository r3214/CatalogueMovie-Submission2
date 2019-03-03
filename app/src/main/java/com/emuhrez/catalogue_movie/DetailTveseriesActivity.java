package com.emuhrez.catalogue_movie;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.emuhrez.catalogue_movie.Model.TvseriesModel;

import java.util.Objects;

public class DetailTveseriesActivity extends AppCompatActivity {

    public static final String DETAIL_TVSERIES = "detail_tvseries";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tveseries);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        }

        TextView tvseriesTitle = findViewById(R.id.tvseries_title_detail);
        TextView tvseriesDate = findViewById(R.id.tvseries_release_detail);
        TextView tvseriesVote = findViewById(R.id.tvseries_vote_detail);
        TextView tvseriesOverview = findViewById(R.id.tvseries_overview_detail);
        ImageView tvseriesPoster = findViewById(R.id.tvseries_poster_detail);

        TvseriesModel tvseriesDetail = getIntent().getParcelableExtra(DETAIL_TVSERIES);

        tvseriesTitle.setText(tvseriesDetail.getTvseriesTitle());
        tvseriesDate.setText(tvseriesDetail.getTvseriesReleasedDate());
        tvseriesOverview.setText(tvseriesDetail.getTvseriesOverview());
        tvseriesVote.setText(String.valueOf(tvseriesDetail.getTvseriesReleasedDate()));
        Glide.with(this)
                .load(tvseriesDetail.getTvseriesPoster())
                .into(tvseriesPoster);
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
