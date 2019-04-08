package com.news.app.activities.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.news.app.activities.details.DetailsActivity;
import com.news.app.listeners.DataLoadListener;
import com.news.app.models.NewsItem;
import com.news.app.utils.Data;


public class MainPresenter implements DataLoadListener {

    private MainView view;
    private AppCompatActivity activity;

    public MainPresenter(MainView view, AppCompatActivity activity) {
        this.view = view;
        this.activity = activity;
        getCurrentDataList();
    }

    public void getCurrentDataList() {
        if (Data.getAllNewsDataLstLst().size() == 0) view.showEmptyView();
        else view.showNewsList(Data.getAllNewsDataLstLst());
    }

    public void updateNewsData(int period) {
        view.showLoadingDialog();
        Data.loadNewsData(period, this, activity);
    }

    public void goToDetailsScreen(Context context, NewsItem newsItem) {
        Intent i = new Intent(context, DetailsActivity.class);
        i.putExtra("newsItem", newsItem);
        context.startActivity(i);
    }

    public void onDestroy() {
        view = null;
    }

    @Override
    public void onDataLoadCompleted() {
        getCurrentDataList();
        view.hideLoadingDialog();
    }
}
