package com.example.cybertech2.timee;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.facebook.FacebookDialog;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

public class ArticleActivity extends AppCompatActivity {

    Toolbar toolbar;
   ShareDialog shareDialog;
    ImageView imageView;
    FloatingActionButton fabShare,fabFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        imageView = findViewById(R.id.imageArticle);
        fabShare = findViewById(R.id.fabShare);
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

        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable_image = imageView.getBackground();
                Bitmap bitmap_image = Helper.drawableToBitmap(drawable_image);

                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(bitmap_image)
                        .build();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();

                ShareContent shareContent = new ShareMediaContent.Builder()
                        .addMedium(photo)
                        .build();


                shareDialog = new ShareDialog(ArticleActivity.this);
                shareDialog.show(shareContent, ShareDialog.Mode.AUTOMATIC);
            }
        });
    }
}
