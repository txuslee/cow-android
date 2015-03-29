package com.jelly.cow.view.activity.impl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.jelly.cow.R;
import com.jelly.cow.configuration.loader.impl.AssetLoader;
import com.jelly.cow.configuration.loader.impl.TextLoader;
import com.jelly.cow.view.activity.IMainActivity;
import com.jelly.cow.view.adapter.WordListAdapter;
import com.jelly.cow.view.presenter.IMainPresenter;
import com.jelly.cow.view.presenter.impl.MainPresenter;

import java.io.IOException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity implements IMainActivity
{
    @InjectView(R.id.cow_text_list)
    public ListView cowListView;

    private IMainPresenter presenter;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        final TextLoader loader = new TextLoader(new AssetLoader(getBaseContext()));
        this.presenter = new MainPresenter(loader);
        presenter.initializeWith(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        try
        {
            this.presenter.load("quijote.txt");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initializeList(final List<String> list)
    {
        this.adapter = new WordListAdapter(this, list);
        this.cowListView.setAdapter(this.adapter);
    }

    @Override
    public void updateList()
    {
        this.adapter.notifyDataSetChanged();
    }
}
