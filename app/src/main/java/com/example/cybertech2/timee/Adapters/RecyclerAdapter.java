package com.example.cybertech2.timee.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cybertech2.timee.ArticleActivity;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int images_id = images[position];
        holder.imageButton.setImageResource(images_id);
        holder.textView.setText("image" + position);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageButton imageButton;
        TextView    textView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.albumImageView);
            textView = itemView.findViewById(R.id.albumTextView);
        }
        public ImageViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.album_layout, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ArticleActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

}
