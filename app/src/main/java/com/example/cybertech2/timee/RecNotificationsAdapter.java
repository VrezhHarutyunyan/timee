package com.example.cybertech2.timee;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class RecNotificationsAdapter extends RecyclerView.Adapter<RecNotificationsAdapter.NotificationsVIewHolder> {
    private static String LOG_TAG = "RecNotificationsAdapter";
    private List<MovieNotifications> list;
    private int count = 0;
    public RecNotificationsAdapter(List<MovieNotifications> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NotificationsVIewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.notifications_view, parent, false);
        return new NotificationsVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationsVIewHolder holder, int position) {


            MovieNotifications movie = list.get(position);
        holder.bind(movie);

        holder.itemView.setOnClickListener(v -> {
            boolean expanded = movie.isExpanded();
            movie.setExpanded(!expanded);
            notifyItemChanged(position);
            count++;
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }



    public class NotificationsVIewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView subTitle;
        private TextView date;

        private ImageView imageView;
        private View subItem;

        public NotificationsVIewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleTextView);
            subTitle = itemView.findViewById(R.id.subTitleTextView);
            date = itemView.findViewById(R.id.dateTextView);
            imageView = itemView.findViewById(R.id.imageViewNotifications);
            subItem = itemView.findViewById(R.id.sub_item_notifications);

        }

        private void bind(MovieNotifications movie) {
            boolean expanded = movie.isExpanded();

            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

            title.setText(movie.getTitle());
            subTitle.setText(movie.getSubTitle());
            date.setText(movie.getDate());
            imageView.setImageResource(R.drawable.ic_notifications);

    if (expanded) {
        imageView.setImageResource(R.drawable.ic_read_notifications);

}
         else if(expanded == false && count>1) {
        imageView.setImageResource(R.drawable.ic_read_notifications);
    }

        }

    }

}
