package com.example.jordy.watchlist;

import android.app.Activity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jordy on 15-11-2016
 * 11433124
 * Minor Programmeren
 * Universiteit van Amsterdam
 *
 * Handles HTTP requests
 */

public class HttpRequestHelper extends Activity {
    // make string for URL
    private static final String url1 = "http://www.omdbapi.com/?s=";

    // method to download from server
    protected static synchronized String downloadFromServer(String... params) {

        // declare return string result
        String result = "";

        // get chosen tag from argument
        String chosenTag = params[0];

        // complete string for URL
        String completeUrl = url1 + chosenTag;

        // turn string into URL
        URL url = null;

        try {
            url = new URL(completeUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // make the connection
        HttpURLConnection connection;
        if (url != null) {
            try {
                connection = (HttpURLConnection) url.openConnection();

                // open connection, set request method
                connection.setRequestMethod("GET");

                // get response code
                Integer responseCode = connection.getResponseCode();


                // if 200-300 read inpuststream
                if (200 <= responseCode && responseCode <= 299) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = br.readLine()) != null) {
                        result = result + line;
                    }
                }
                // else, read error stream
                else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    // communicate correct error “server is not online” oid.
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // return result
            return result;

        }

    return result;
    }
}