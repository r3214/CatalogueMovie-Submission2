package com.emuhrez.catalogue_movie.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MoviesModel implements Parcelable {
    private String moviesTitle;
    private String moviesReleasedDate;
    private String moviesOverview;
    private Double moviesVote;
    private Integer moviesPoster;

    public String getMoviesTitle() {
        return moviesTitle;
    }

    public void setMoviesTitle(String moviesTitle) {
        this.moviesTitle = moviesTitle;
    }

    public String getMoviesReleasedDate() {
        return moviesReleasedDate;
    }

    public void setMoviesReleasedDate(String moviesReleasedDate) {
        this.moviesReleasedDate = moviesReleasedDate;
    }

    public String getMoviesOverview() {
        return moviesOverview;
    }

    public void setMoviesOverview(String moviesOverview) {
        this.moviesOverview = moviesOverview;
    }

    public Double getMoviesVote() {
        return moviesVote;
    }

    public void setMoviesVote(Double moviesVote) {
        this.moviesVote = moviesVote;
    }

    public Integer getMoviesPoster() {
        return moviesPoster;
    }

    public void setMoviesPoster(Integer moviesPoster) {
        this.moviesPoster = moviesPoster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.moviesTitle);
        dest.writeString(this.moviesReleasedDate);
        dest.writeString(this.moviesOverview);
        dest.writeValue(this.moviesVote);
        dest.writeValue(this.moviesPoster);
    }

    public MoviesModel() {
    }

    protected MoviesModel(Parcel in) {
        this.moviesTitle = in.readString();
        this.moviesReleasedDate = in.readString();
        this.moviesOverview = in.readString();
        this.moviesVote = (Double) in.readValue(Double.class.getClassLoader());
        this.moviesPoster = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<MoviesModel> CREATOR = new Parcelable.Creator<MoviesModel>() {
        @Override
        public MoviesModel createFromParcel(Parcel source) {
            return new MoviesModel(source);
        }

        @Override
        public MoviesModel[] newArray(int size) {
            return new MoviesModel[size];
        }
    };
}
