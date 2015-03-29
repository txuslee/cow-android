package com.jelly.cow.task.impl;

import android.os.AsyncTask;

import com.jelly.cow.configuration.loader.ITextLoader;
import com.jelly.cow.task.IWordProcessorTask;
import com.jelly.cow.view.presenter.IMainPresenter;

import java.io.IOException;

public class WordProcessorTask extends AsyncTask<String, String, Void> implements IWordProcessorTask
{
    private final IMainPresenter presenter;
    private final ITextLoader loader;

    public WordProcessorTask(final IMainPresenter presenter, final ITextLoader loader)
    {
        this.presenter = presenter;
        this.loader = loader;
    }

    @Override
    public void doExecute(String parameter)
    {
        this.execute(parameter);
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        this.presenter.startLoading();
    }

    @Override
    protected Void doInBackground(String... params)
    {
        try
        {
            final String text = this.loader.load(params[0]);
            final String[] words = text.split("[\\W]");
            for (String word : words)
            {
                if (!word.equalsIgnoreCase(""))
                {
                    this.publishProgress(word);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(String... values)
    {
        super.onProgressUpdate(values);
        this.presenter.updateProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
        this.presenter.stopLoading();
    }

    @Override
    protected void onCancelled(Void aVoid)
    {
        super.onCancelled(aVoid);
    }

    @Override
    protected void onCancelled()
    {
        super.onCancelled();
    }
}
