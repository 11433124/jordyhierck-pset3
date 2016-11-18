package com.example.jordy.watchlist;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by Jordy on 15-11-2016
 * 11433124
 * Minor Programmeren
 * Universiteit van Amsterdam
 *
 * Manage threads in the app
 */


public class MovieAsyncTask extends AsyncTask<String, Integer, String> {

    Context context;
    MainActivity activity;

    // constructor waarmee je een instance kan aanmaken. In deze class kunnen we nu ook bij de main activity.
    public void TagAsyncTask(MainActivity activity) {
        this.activity = activity;
        this.context = this.activity.getApplicationContext(); // mogelijk niet nodig


        // onPreExecute(). Toast wordt nu aangemaakt. In main activity maken we toast aan, end an nu gaan we pas echt de functie uitvoeren end us wordt dan de toast geshowed.

    protected void onPreExecute() {
        Toast.makeText(context, "Getting data from server", Toast.LENGTH_LONG);
    }

    protected String doInBackground(String... params) {
        return HttpRequestHelper.downloadFromServer(params);
        // automatisch wordt wat we hier in background returnen, meegegeven aan onPostExecute
    }

    // onPostExecute
    protected void onPostExecute(String result) {
        super.onPostExecute(result);


        // tag slaat nergens op of verbinding is niet gelukt
        if (result.length() == 0) {
            Toast.makeText(context, "No data was found", Toast.LENGTH_LONG);
        }
        else {
            // in TrackData staan titel, omschrijving e.d., zelf aangemaakt.
            ArrayList<MovieData> trackdata = new ArrayList<>();
            try {
                JSONObject respObj = new JSONObject(result);
                JSONObject moviesObj = respObj.getJSONObject("movies");
                JSONArray movies = moviesObj.getJSONArray("movie");

                // doorloop het JSON om elk object eruit te halen
                for (int i = 0; i < movies.length(); i++) {
                    JSONObject movie = movies.getJSONObject(i);
                    String title = movie.getString("Title");
                    String year = movie.getString("Year");
                    String runtime = movie.getString("Runtime");
                    String genre = movie.getString("Genre");
                    String actors = movie.getString("Actors");
                    String plot = movie.getString("Plot");
                    String language = movie.getString("Language");
                    String poster = movie.getString("Poster");
                    String imdb = movie.getString("imdbRating");
                    trackdata.add(new MovieData(title, year, runtime, genre, actors, plot, language, poster, imdb));
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            this.activity.setData(trackdata);

        }
    }
}
