package com.jelly.cow.view.activity.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.jelly.cow.R;
import com.jelly.cow.configuration.loader.impl.AssetLoader;
import com.jelly.cow.configuration.loader.impl.TextLoader;
import com.jelly.cow.task.IWordProcessorTask;
import com.jelly.cow.task.impl.WordProcessorTask;
import com.jelly.cow.view.activity.IMainActivity;
import com.jelly.cow.view.adapter.WordListAdapter;
import com.jelly.cow.view.presenter.IMainPresenter;
import com.jelly.cow.view.presenter.impl.MainPresenter;

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
        this.requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        this.setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        this.presenter = new MainPresenter();
        presenter.initializeWith(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        final TextLoader loader = new TextLoader(new AssetLoader(getBaseContext()));
        final IWordProcessorTask task = new WordProcessorTask(this.presenter, loader);
        task.doExecute("quijote.txt");
    }

    @Override
    public void initializeList(final List<String> list)
    {
        this.adapter = new WordListAdapter(this, this.presenter);
        this.cowListView.setAdapter(this.adapter);
    }

    public void startLoading()
    {
        this.setProgressBarIndeterminateVisibility(Boolean.TRUE);
    }

    @Override
    public void updateList()
    {
        this.adapter.notifyDataSetChanged();
    }

    public void stopLoading()
    {
        this.setProgressBarIndeterminateVisibility(Boolean.FALSE);
    }
}
