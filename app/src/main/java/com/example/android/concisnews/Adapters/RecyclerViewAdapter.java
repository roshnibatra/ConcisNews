package com.example.android.concisnews.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.concisnews.Dtos.News;
import com.example.android.concisnews.R;
import com.example.android.concisnews.activity.MainActivity;

import java.io.InputStream;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NewsViewHolder> {

    private List<News> newsList;
    Context context;

    public RecyclerViewAdapter(Context context,List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    public void setNewsList(List<News> news) {
        this.newsList = news;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_content, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News newsData = newsList.get(position);
        if(newsData != null) {
            new DownloadImageTask(holder.image)
                    .execute(newsData.getUrlToImage());
            holder.title.setText(newsData.getTitle());
            holder.content.setText(newsData.getContent());
            holder.url.setText(newsData.getUrl());
        }


    }

    @Override
    public int getItemCount() {
        return newsList != null ? newsList.size() : 0;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView title, content;
        TextView url;
        ImageView image;
        ImageButton share;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_news);
            content = itemView.findViewById(R.id.content_news);
            url = itemView.findViewById(R.id.hyperlink_news);
            Linkify.addLinks(url, Linkify.ALL);
            image = itemView.findViewById(R.id.image_news);
            share = itemView.findViewById(R.id.share_news);
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/html");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, title.getText());
                        context.startActivity(Intent.createChooser(shareIntent, "Shared via Concis"));
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.i("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
