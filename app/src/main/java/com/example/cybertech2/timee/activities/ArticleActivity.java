package com.example.cybertech2.timee.activities;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cybertech2.timee.R;
import com.facebook.CallbackManager;
import com.facebook.share.widget.ShareDialog;

public class ArticleActivity extends AppCompatActivity {

    Toolbar toolbar;
    AppBarLayout appBarLayout;
    TextView textView;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    ImageView imageView;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton fabShare, fabFavorites;
    boolean appBarExpanded;
    private boolean collapsedMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        appBarLayout = findViewById(R.id.app_bar);
       // textView = findViewById(R.id.textViewWord);
        collapsingToolbarLayout = findViewById(R.id.collapstoolbar);
        imageView = findViewById(R.id.imageArticle);
     //   fabShare = findViewById(R.id.fabShare);
        fabFavorites = findViewById(R.id.fabFavorites);
        toolbar = findViewById(R.id.toolbarArticle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        collapsingToolbarLayout.setTitle("Suleiman");

       appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                //  Vertical offset == 0 indicates appBar is fully  expanded.
                if (Math.abs(verticalOffset) > 200) {
                    appBarExpanded = false;
                    invalidateOptionsMenu();
                } else {
                    appBarExpanded = true;
                    invalidateOptionsMenu();
                }
            }
        });

//            fabShare.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//
//                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                    sharingIntent.setType("text/plain");
//                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "http://www.google.com");
//                    startActivity(Intent.createChooser(sharingIntent, "Share via"));

//                Drawable drawable_image = imageView.getBackground();
//                Bitmap bitmap_image = Helper.drawableToBitmap(drawable_image);



//                    shareDialog = new ShareDialog(ArticleActivity.this);
//                    shareDialog.show(content, ShareDialog.Mode.AUTOMATIC);
//
//
////                SharePhotoContent content = new SharePhotoContent.Builder()
//                        .addPhoto(photo)
//                        .build();
//
//                ShareContent shareContent = new ShareMediaContent.Builder()
//                        .addMedium(photo)
//                        .build();
//
//
//                shareDialog = new ShareDialog(ArticleActivity.this);
//                shareDialog.show(shareContent, ShareDialog.Mode.AUTOMATIC);
//                }
//            });
//
//        }

        }
}