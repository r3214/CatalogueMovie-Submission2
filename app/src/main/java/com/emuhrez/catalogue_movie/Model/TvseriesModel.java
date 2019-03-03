package com.emuhrez.catalogue_movie.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvseriesModel implements Parcelable {
    private String tvseriesTitle;
    private String tvseriesReleasedDate;
    private String tvseriesOverview;
    private Double tvseriesVote;
    private Integer tvseriesPoster;

    public String getTvseriesTitle() {
        return tvseriesTitle;
    }

    public void setTvseriesTitle(String tvseriesTitle) {
        this.tvseriesTitle = tvseriesTitle;
    }

    public String getTvseriesReleasedDate() {
        return tvseriesReleasedDate;
    }

    public void setTvseriesReleasedDate(String tvseriesReleasedDate) {
        this.tvseriesReleasedDate = tvseriesReleasedDate;
    }

    public String getTvseriesOverview() {
        return tvseriesOverview;
    }

    public void setTvseriesOverview(String tvseriesOverview) {
        this.tvseriesOverview = tvseriesOverview;
    }

    public Double getTvseriesVote() {
        return tvseriesVote;
    }

    public void setTvseriesVote(Double tvseriesVote) {
        this.tvseriesVote = tvseriesVote;
    }

    public Integer getTvseriesPoster() {
        return tvseriesPoster;
    }

    public void setTvseriesPoster(Integer tvseriesPoster) {
        this.tvseriesPoster = tvseriesPoster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tvseriesTitle);
        dest.writeString(this.tvseriesReleasedDate);
        dest.writeString(this.tvseriesOverview);
        dest.writeValue(this.tvseriesVote);
        dest.writeValue(this.tvseriesPoster);
    }

    public TvseriesModel() {
    }

    protected TvseriesModel(Parcel in) {
        this.tvseriesTitle = in.readString();
        this.tvseriesReleasedDate = in.readString();
        this.tvseriesOverview = in.readString();
        this.tvseriesVote = (Double) in.readValue(Double.class.getClassLoader());
        this.tvseriesPoster = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<TvseriesModel> CREATOR = new Parcelable.Creator<TvseriesModel>() {
        @Override
        public TvseriesModel createFromParcel(Parcel source) {
            return new TvseriesModel(source);
        }

        @Override
        public TvseriesModel[] newArray(int size) {
            return new TvseriesModel[size];
        }
    };
}
