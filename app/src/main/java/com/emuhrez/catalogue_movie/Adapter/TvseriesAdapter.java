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
import com.emuhrez.catalogue_movie.Model.TvseriesModel;
import com.emuhrez.catalogue_movie.R;

import java.util.ArrayList;

public class TvseriesAdapter extends RecyclerView.Adapter<TvseriesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TvseriesModel> listTvseries;

    public ArrayList<TvseriesModel> getListTvseries() {
        return listTvseries;
    }

    public void setListTvseries(ArrayList<TvseriesModel> listTvseries) {
        this.listTvseries = listTvseries;
    }

    public TvseriesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tvseries,viewGroup,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvseriesTitle.setText(getListTvseries().get(i).getTvseriesTitle());
        viewHolder.tvseriesOverview.setText(getListTvseries().get(i).getTvseriesOverview());
        Glide.with(context)
                .load(getListTvseries().get(i).getTvseriesPoster())
                .into(viewHolder.tvseriesPoster);
    }

    @Override
    public int getItemCount() {
        return listTvseries.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvseriesTitle;
        TextView tvseriesOverview;
        ImageView tvseriesPoster;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvseriesTitle = itemView.findViewById(R.id.id_tvseries_title);
            tvseriesOverview = itemView.findViewById(R.id.id_tvseries_description);
            tvseriesPoster = itemView.findViewById(R.id.id_tvseries_poster);

        }
    }
}
