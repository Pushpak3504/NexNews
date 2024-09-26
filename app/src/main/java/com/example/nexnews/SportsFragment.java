package com.example.nexnews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {
    String apikey = "112467e9d55741bab456a359cbd467d0";

    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewofSports;

    private String category = "sports";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sportsfragment, null);

        recyclerViewofSports = view.findViewById(R.id.recyclerofsports);

        modelClassArrayList = new ArrayList<>();

        recyclerViewofSports.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter(getContext(), modelClassArrayList);

        recyclerViewofSports.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,apikey).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}