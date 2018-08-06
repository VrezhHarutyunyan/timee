package com.example.cybertech2.timee.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cybertech2.timee.activities.ArticleActivity;
import com.example.cybertech2.timee.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    private int[] images;
        private TextView textView;
    public RecyclerAdapter(int [] images,TextView textView){
        this.images = images;
        this.textView = textView;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int images_id = images[position];
        holder.imageButton.setImageResource(images_id);
        holder.textView.setText("image" + position);
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ArticleActivity.class);
//                intent.putExtra(Title, superHero.getName());
//                intent.putExtra("URL", superHero.getImageUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageButton imageButton;
        TextView    textView,textViewTopic,textViewDate,textViewViewCount;
        ImageView   imageViewDate,imageViewViewCount,imageViewStar;

        public ImageViewHolder(View itemView) {
            super(itemView);
                      imageButton = itemView.findViewById(R.id.recycler_item_image);
            textView = itemView.findViewById(R.id.item_name);
            textViewTopic = itemView.findViewById(R.id.item_topic);
            textViewDate = itemView.findViewById(R.id.post_date);
            textViewViewCount = itemView.findViewById(R.id.views_count);
            imageViewDate = itemView.findViewById(R.id.date_image);
            imageViewViewCount = itemView.findViewById(R.id.viewsCount_image);
            imageViewStar = itemView.findViewById(R.id.hiRates);

        }
        public ImageViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.recyclerview_item, parent, false));
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, ArticleActivity.class);
//                    context.startActivity(intent);
//                }
//            });
        }
    }

}
