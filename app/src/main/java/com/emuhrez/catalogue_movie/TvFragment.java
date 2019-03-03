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

import com.emuhrez.catalogue_movie.Adapter.TvseriesAdapter;
import com.emuhrez.catalogue_movie.Model.TvseriesModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {

    private RecyclerView recyclerViewTvseries;
    private ArrayList<TvseriesModel> listTvseries = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tv, container, false);
        recyclerViewTvseries = rootView.findViewById(R.id.rv_tvseries);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initialization();
        showListTvseries();
    }

    private void showListTvseries(){
        recyclerViewTvseries.setLayoutManager(new LinearLayoutManager(getContext()));
        TvseriesAdapter tvseriesAdapter= new TvseriesAdapter(getContext());
        tvseriesAdapter.setListTvseries(listTvseries);
        recyclerViewTvseries.setAdapter(tvseriesAdapter);

        ItemSupport.addTo(recyclerViewTvseries).setOnItemClickListener(new ItemSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent tvseriesDetail = new Intent(getContext(), DetailTveseriesActivity.class);
                tvseriesDetail.putExtra(DetailTveseriesActivity.DETAIL_TVSERIES, listTvseries.get(position));
                startActivity(tvseriesDetail);
            }
        });
    }

    private void initialization() {
        String[] tvseriesTitle = getResources().getStringArray(R.array.tvseries_title);
        String[] tvseriesRelease = getResources().getStringArray(R.array.tvseries_first_release);
        String[] tvseriesVote = getResources().getStringArray(R.array.tvseries_vote);
        String[] tvseriesOverview = getResources().getStringArray(R.array.tvseries_overview);
        @SuppressLint("Recycle") TypedArray tvseriesImage = getResources().obtainTypedArray(R.array.tvseries_poster);

        for (int i = 0; i < tvseriesTitle.length; i++) {
            TvseriesModel tvseriesModel = new TvseriesModel();
            tvseriesModel.setTvseriesTitle(tvseriesTitle[i]);
            tvseriesModel.setTvseriesReleasedDate(tvseriesRelease[i]);
            tvseriesModel.setTvseriesVote(Double.valueOf(tvseriesVote[i]));
            tvseriesModel.setTvseriesOverview(tvseriesOverview[i]);
            tvseriesModel.setTvseriesPoster(tvseriesImage.getResourceId(i, -1));
            listTvseries.add(tvseriesModel);
        }
    }
}
