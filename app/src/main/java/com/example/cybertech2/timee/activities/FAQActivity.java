package com.example.cybertech2.timee.activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;

import com.example.cybertech2.timee.model.Movie;
import com.example.cybertech2.timee.R;
import com.example.cybertech2.timee.adapters.RecAdapter;

import java.util.ArrayList;
import java.util.List;

public class FAQActivity extends AppCompatActivity {



    android.support.v7.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Movie> movieList = new ArrayList<>();
    RecAdapter adapter = new RecAdapter(movieList);

    @SuppressLint({"ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);
        toolbar = findViewById(R.id.toolbarFAQ);
        recyclerView = findViewById(R.id.recyclerViewExpand);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        movieList.add(new Movie("1", "Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History"));
        movieList.add(new Movie("2", "Crime, Drama"));
        movieList.add(new Movie("3", "Crime, Drama, Thriller"));
        movieList.add(new Movie("4", "Crime, Drama, Thriller"));
        movieList.add(new Movie("5", "Drama"));
        movieList.add(new Movie("6", "Drama, Romance"));
        movieList.add(new Movie("7", "Crime, Drama"));
        movieList.add(new Movie("8", "Crime, Drama"));
        movieList.add(new Movie("9", "Biography, Drama"));
        movieList.add(new Movie("10", "Drama"));

        RecAdapter adapter = new RecAdapter(movieList);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }


}

