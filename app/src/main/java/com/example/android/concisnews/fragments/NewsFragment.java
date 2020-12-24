package com.example.android.concisnews.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android.concisnews.Adapters.RecyclerViewAdapter;
import com.example.android.concisnews.Dtos.News;
import com.example.android.concisnews.Dtos.SourceDto;
import com.example.android.concisnews.R;
import com.example.android.concisnews.activity.WebViewActivity;
import com.example.android.concisnews.apiInterface.FragmentInterface;
import com.example.android.concisnews.apiInterface.RetrofitApi;
import com.example.android.concisnews.retrofitInstance.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    private static final String TAG = "NewsFragment";
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<News> newsList;
    LottieAnimationView animationView;
   // ProgressBar progressBar;

    public NewsFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        animationView = view.findViewById(R.id.animationView);
        animationView.setVisibility(View.VISIBLE);
//        progressBar = view.findViewById(R.id.loading_bar);
//        progressBar.setVisibility(View.VISIBLE);
        recyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(),newsList, fragmentInterface);
        recyclerView.setAdapter(recyclerViewAdapter);

        LinearSnapHelper linearSnapHelper = new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(recyclerView);

        RetrofitApi retrofitApi = RetrofitClientInstance.getRetrofitInstance().create(RetrofitApi.class);
        Call<List<News>> call = retrofitApi.getNews();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(response.isSuccessful()) {
                    animationView.setVisibility(View.GONE);
                 //   progressBar.setVisibility(View.GONE);
                    List<News> news = response.body();
                    recyclerViewAdapter.setNewsList(news);
                }

            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                t.printStackTrace();
            }
        });


        return view;
    }

    public class SnapHelperOneByOne extends LinearSnapHelper {

        @Override
        public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY){

            if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
                return RecyclerView.NO_POSITION;
            }

            final View currentView = findSnapView(layoutManager);

            if( currentView == null ){
                return RecyclerView.NO_POSITION;
            }

            final int currentPosition = layoutManager.getPosition(currentView);

            return currentPosition;
        }
    }

    FragmentInterface fragmentInterface = new FragmentInterface() {
        @Override
        public void sentUrl(String url) {
            Log.i(TAG, "get sentUrl: " + url);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    };
}