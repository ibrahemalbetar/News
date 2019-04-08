package com.news.app.activities.spalsh;

import android.support.v7.app.AppCompatActivity;

import com.news.app.listeners.DataLoadListener;
import com.news.app.utils.Data;


public class SplashPresenter implements DataLoadListener {

    SpalshView spalshView;

    public SplashPresenter(SpalshView spalshView, AppCompatActivity activity) {
        this.spalshView = spalshView;
        Data.loadNewsData(1, this, activity);
    }

    @Override
    public void onDataLoadCompleted() {
        spalshView.navigateToMain();
    }

    public void onDestroy() {
        spalshView = null;
    }
}
