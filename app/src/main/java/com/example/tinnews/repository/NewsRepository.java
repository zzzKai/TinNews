package com.example.tinnews.repository;

import android.content.Context;

import com.example.tinnews.network.NewsApi;
import com.example.tinnews.network.RetrofitClient;

public class NewsRepository {
    private final NewsApi newsApi;

    public NewsRepository(Context context) {
        newsApi = RetrofitClient.newInstance(context).create(NewsApi.class);
    }
}
