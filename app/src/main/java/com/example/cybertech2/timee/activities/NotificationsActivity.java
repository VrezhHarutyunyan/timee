package com.example.cybertech2.timee.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.cybertech2.timee.model.MovieNotifications;
import com.example.cybertech2.timee.R;
import com.example.cybertech2.timee.adapters.RecNotificationsAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

        Toolbar toolbar;

    RecyclerView recyclerViewNotifications;
    RecyclerView.LayoutManager layoutManager;
    List<MovieNotifications> movieList = new ArrayList<>();
    RecNotificationsAdapter adapter = new  RecNotificationsAdapter(movieList);
    private RecyclerView.Adapter mAdapter;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        recyclerViewNotifications = findViewById(R.id.recyclerViewNotifications);
        toolbar = findViewById(R.id.toolbarNotifications);
        imageView = findViewById(R.id.imageViewNotifications);

//        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
//        itemTouchhelper.attachToRecyclerView(recyclerViewNotifications);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        movieList.add(new MovieNotifications("Timee", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));
        movieList.add(new MovieNotifications("Դավիթ Հարությունյան", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));
        movieList.add(new MovieNotifications("Վազգեն", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));
        movieList.add(new MovieNotifications("Եդուարդ Հավհաննիսյան", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));
        movieList.add(new MovieNotifications("Timee", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));
        movieList.add(new MovieNotifications("Նվեր Ծառուկյան", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));
        movieList.add(new MovieNotifications("Timee", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));
        movieList.add(new MovieNotifications("Timee", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));
        movieList.add(new MovieNotifications("Timee", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));
        movieList.add(new MovieNotifications("Timee", "fsdfsdfdsfdfdfdfcxcdsfcxzcssdsdsdadadsaBiography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History Biography, Drama, History", "13.07.18"));

        RecNotificationsAdapter adapter = new RecNotificationsAdapter(movieList);
        ((SimpleItemAnimator) recyclerViewNotifications.getItemAnimator()).setSupportsChangeAnimations(false);

        recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotifications.setAdapter(adapter);
        recyclerViewNotifications.setHasFixedSize(true);

    }


}
