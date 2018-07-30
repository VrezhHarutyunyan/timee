package com.example.cybertech2.timee;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookDialog;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareDialog;

import java.io.File;

import bolts.AppLinks;

public class ArticleActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView textView;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    ImageView imageView;
    FloatingActionButton fabShare, fabFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        textView = findViewById(R.id.textViewWord);
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



                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "http://www.google.com");
                    startActivity(Intent.createChooser(sharingIntent, "Share via"));

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
                }
            });
        }
    }
