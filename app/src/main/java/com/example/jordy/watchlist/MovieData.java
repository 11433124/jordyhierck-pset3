package com.example.jordy.watchlist;

import android.app.Activity;

/**
 * Created by Jordy on 15-11-2016.
 */

public class MovieData {

    public String title;
    public String year;
    public String runtime;
    public String genre;
    public String actors;
    public String plot;
    public String poster;
    public String language;
    public String imdb;

    public MovieData(String title, String year, String runtime, String genre, String actors, String plot, String poster, String language, String imdb){
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.genre = genre;
        this.actors = actors;
        this.plot = plot;
        this.poster = poster;
        this.language = language;
        this.imdb = imdb;
    }

    public String getTitle() {
        return title;
    }

    public String getActors() {
        return actors;
    }

    public String getGenre() {
        return genre;
    }

    public String getImdb() {
        return imdb;
    }

    public String getLanguage() {
        return language;
    }

    public String getPlot() {
        return plot;
    }

    public String getPoster() {
        return poster;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getYear() {
        return year;
    }

}
