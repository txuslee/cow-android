package com.jelly.cow.view.activity.impl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.jelly.cow.R;
import com.jelly.cow.configuration.loader.impl.AssetLoader;
import com.jelly.cow.configuration.loader.impl.TextLoader;
import com.jelly.cow.view.activity.IMainActivity;
import com.jelly.cow.view.presenter.IMainPresenter;
import com.jelly.cow.view.presenter.impl.MainPresenter;

import java.io.IOException;
import java.util.List;


public class MainActivity extends Activity implements IMainActivity
{
    private IMainPresenter presenter;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

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
        final ListView cowListView = (ListView) this.findViewById(R.id.cow_text_list);
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        cowListView.setAdapter(this.adapter);
    }

    @Override
    public void updateList()
    {
        this.adapter.notifyDataSetChanged();
    }
}
