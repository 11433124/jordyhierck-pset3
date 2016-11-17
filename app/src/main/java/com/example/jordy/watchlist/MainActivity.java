package com.example.jordy.watchlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.util.ArrayList;


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
        Intent getWatchlistView = new Intent(this, TracksAdapter.class);

        startActivity(getWatchlistView);

    }


}
