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
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.concisnews.Dtos.News;
import com.example.android.concisnews.R;
import com.example.android.concisnews.activity.MainActivity;
import com.example.android.concisnews.apiInterface.FragmentInterface;

import java.io.InputStream;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NewsViewHolder> {

    private List<News> newsList;
    Context context;
    private FragmentInterface mFragmentInterface;
    boolean isImageFitToScreen;

    public RecyclerViewAdapter(Context context,List<News> newsList, FragmentInterface i) {
        this.context = context;
        this.newsList = newsList;
        mFragmentInterface = i;
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

        return new NewsViewHolder(view, mFragmentInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News newsData = newsList.get(position);
        if(newsData != null) {
            new DownloadImageTask(holder.image)
                    .execute(newsData.getBetter_featured_image().getSource_url());
            holder.title.setText(newsData.getTitle().getRendered());
            holder.content.setText(newsData.getExcerpt().getRendered());
        }
    }

    @Override
    public int getItemCount() {
        return newsList != null ? newsList.size() : 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, content;
        TextView url;
        ImageView image;
        ImageButton share;
        FragmentInterface fragmentInterface;

        public NewsViewHolder(@NonNull View itemView, FragmentInterface f) {
            super(itemView);

            fragmentInterface = f;
            title = itemView.findViewById(R.id.title_news);
            content = itemView.findViewById(R.id.content_news);
            url = itemView.findViewById(R.id.hyperlink_news);
            image = itemView.findViewById(R.id.image_news);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isImageFitToScreen) {
                        isImageFitToScreen=false;
                        image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        image.setAdjustViewBounds(true);
//                        zoomImageFromThumb(image, R.drawable.);
                        
                    }else{
                        isImageFitToScreen=true;
                        image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                }
            });
            share = itemView.findViewById(R.id.share_news);
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/text");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, title.getText());
                        shareIntent.putExtra(Intent.EXTRA_TEXT, url.getText());
                        Log.d("Main",url.toString());
                        context.startActivity(Intent.createChooser(shareIntent, "Shared via Concis"));
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            url.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            fragmentInterface.sentUrl(newsList.get(getAdapterPosition()).getLink());
        }

        public void zoomImageFromThumb() {

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
