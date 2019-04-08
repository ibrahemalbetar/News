package com.news.app.activities.main;


import com.news.app.models.NewsItem;

import java.util.List;


public interface MainView {
    public void showNewsList(List<NewsItem> newsItems);

    public void onNewsItemClicked(NewsItem newsItem);

    public void updateNewsData();

    public void showEmptyView();

    public void showLoadingDialog();

    public void hideLoadingDialog();
}
