package com.news.app.utils;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.news.app.client.AppClient;
import com.news.app.listeners.DataLoadListener;
import com.news.app.models.ApiResponse;
import com.news.app.models.NewsItem;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class Data {
    private static List<NewsItem> allNewsDataLst = new ArrayList<>();
    private static DataLoadListener mDataLoad;

    public static List<NewsItem> getAllNewsDataLstLst() {
        return allNewsDataLst;
    }

    //load all News
    public static void loadNewsData(int period, final DataLoadListener dataLoadListener, final AppCompatActivity activity) {
        AppClient.getClient().getAllNews(period + ".json", Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ApiResponse apiResponse) {
                        allNewsDataLst = apiResponse.getResults();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {
                        dataLoadListener.onDataLoadCompleted();
                    }
                });
    }
}
