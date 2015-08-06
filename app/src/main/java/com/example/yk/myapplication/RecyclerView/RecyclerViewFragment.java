package com.example.yk.myapplication.RecyclerView;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yk.myapplication.R;

/**
 * Created by yk on 15/8/6.
 */
public class RecyclerViewFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recycler_view_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        String[] strings = {"test1","test2","test3","test4","test5","test6","test7"};
        recyclerViewAdapter = new RecyclerViewAdapter(strings,getActivity());
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(),"点击的是item"+position,Toast.LENGTH_LONG).show();
            }
        });
    }
}
