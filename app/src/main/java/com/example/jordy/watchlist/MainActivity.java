package com.example.jordy.watchlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private EditText user_input;
    private Button watchlist;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void watchlistView(View view){
        Intent getWatchlistView = new Intent(this, MovieAdapter.class);

        startActivity(getWatchlistView);

    }

    public void searchView(View view){
        EditText user_input = (EditText) findViewById(R.id.user_input);

        if (user_input.length() != 0) {
            String movieTitle = user_input.getText().toString();

            MovieAsyncTask asyncTask = new MovieAsyncTask(this);
            asyncTask.execute(movieTitle);
        }
        else {
            user_input.setError("Please enter a movietitle");
        }

        user_input.setText("");
    }

    public void setData(){

    }

}
