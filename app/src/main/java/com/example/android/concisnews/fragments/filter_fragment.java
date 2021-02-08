package com.example.android.concisnews.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.concisnews.Adapters.RecyclerViewFilterAdapter;
import com.example.android.concisnews.Dtos.MainFilter;
import com.example.android.concisnews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link filter_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class filter_fragment extends Fragment {

    RecyclerView recyclerViewFilter;
    RecyclerViewFilterAdapter recyclerViewFilterAdapter;
    List<MainFilter> filterList;

    public filter_fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static filter_fragment newInstance() {
        filter_fragment fragment = new filter_fragment();
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
        View rootView = inflater.inflate(R.layout.filter_header, container, false);
        recyclerViewFilter = rootView.findViewById(R.id.recycler_view_filter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);
        recyclerViewFilter.setLayoutManager(layoutManager);
        recyclerViewFilterAdapter = new RecyclerViewFilterAdapter(filterList , getContext());
        recyclerViewFilter.setAdapter(recyclerViewFilterAdapter);
          filterList = new ArrayList<>();

          filterList.add(new MainFilter("Industries","Add/Select Industries"));
          filterList.add(new MainFilter("Geography","Add/choose Locations"));
          filterList.add(new MainFilter("Date Range","Filter by date"));
          filterList.add(new MainFilter("Topics","Topic wise filter"));

//        filterList.add(new MainFilter("Education",""));
//        filterList.add(new MainFilter("Telecommunication",""));
//        filterList.add(new MainFilter("Retail",""));
//        filterList.add(new MainFilter("HealthCare",""));
//        filterList.add(new MainFilter("Travel & Hospitality",""));
//        filterList.add(new MainFilter("Real Estate",""));
//        filterList.add(new MainFilter("Media & Entertainment",""));
//        filterList.add(new MainFilter("Govt",""));
//        filterList.add(new MainFilter("Tech",""));
//        filterList.add(new MainFilter("BFSI",""));
//        filterList.add(new MainFilter("CPG / FMCG / Manufacturing",""));
//        filterList.add(new MainFilter("Advisory",""));
//        filterList.add(new MainFilter("Renewables",""));
//        filterList.add(new MainFilter("Logistics and Supply Chain",""));


//        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getContext()),
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);

        return rootView;
    }


    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
}