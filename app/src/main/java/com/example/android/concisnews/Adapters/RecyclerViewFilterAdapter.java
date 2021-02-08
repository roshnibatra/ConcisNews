package com.example.android.concisnews.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.concisnews.Dtos.MainFilter;
import com.example.android.concisnews.Dtos.News;
import com.example.android.concisnews.R;

import java.util.List;

public class RecyclerViewFilterAdapter extends RecyclerView.Adapter<RecyclerViewFilterAdapter.FilterViewHolder> {

    private List<MainFilter> filterList;
    Context context;

    public RecyclerViewFilterAdapter(List<MainFilter> filterList, Context context) {
        this.filterList = filterList;
        this.context = context;
    }

    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_filter_content, parent, false);
        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {
        MainFilter filter = filterList.get(position);
        if(filter != null) {
            holder.header.setText(filter.getHeader());
            holder.sub_header.setText(filter.getSub_header());
        }
    }

    @Override
    public int getItemCount() {
        return filterList != null ? filterList.size() : 0;
    }

    public class FilterViewHolder extends RecyclerView.ViewHolder {

        TextView header, sub_header;

        public FilterViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.main_header);
            sub_header = itemView.findViewById(R.id.sub_header);
        }
    }
}
