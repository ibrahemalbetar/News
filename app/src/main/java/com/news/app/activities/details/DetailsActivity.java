package com.news.app.activities.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.news.app.R;
import com.news.app.models.NewsItem;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity implements DetailsView {

    private DetailsPresenter presenter;

    @BindView(R.id.header)
    ImageView header;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.details)
    TextView details;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.section)
    TextView section;
    @BindView(R.id.source)
    TextView source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        presenter = new DetailsPresenter(DetailsActivity.this, this);
    }

    @Override
    public void showNewsDetails(NewsItem newsItem) {
        Picasso.get()
                .load(newsItem.getMedia().get(0).getMetadata().get(4).getUrl())
                .placeholder(R.color.white)
                .error(R.color.colorPrimary)
                .into(header);
        title.setText(newsItem.getTitle());
        details.setText(newsItem.getDetails());
        date.setText(newsItem.getPublished_date());
        section.setText(newsItem.getSection());
        source.setText(newsItem.getSource());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
