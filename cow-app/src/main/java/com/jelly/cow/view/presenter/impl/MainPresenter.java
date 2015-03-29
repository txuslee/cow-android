package com.jelly.cow.view.presenter.impl;

import com.jelly.cow.configuration.loader.ITextLoader;
import com.jelly.cow.view.activity.IMainActivity;
import com.jelly.cow.view.presenter.IMainPresenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainPresenter extends BasePresenter<IMainActivity> implements IMainPresenter
{
    private final Map<String, Integer> counter;
    private final List<String> list;
    private final ITextLoader loader;

    public MainPresenter(final ITextLoader loader)
    {
        this.counter = new HashMap<String, Integer>();
        this.list = new ArrayList<String>();
        this.loader = loader;
    }

    @Override
    public void initializeWith(final IMainActivity activity)
    {
        super.initializeWith(activity);
        activity.initializeList(this.list);
    }

    @Override
    public void load(final String uri) throws IOException
    {
        final String text = this.loader.load(uri);
        final String[] words = text.split("[\\W]");
        for (String word : words)
        {
            if (!word.equalsIgnoreCase(""))
            {
                this.updateWordCount(word);
                this.list.add(word);

                final IMainActivity activity = this.getActivity();
                if (activity != null)
                {
                    activity.updateList();
                }
            }
        }
    }

    private void updateWordCount(final String word)
    {
        Integer count = this.getWordCount(word);
        this.counter.put(word.toLowerCase(), ++count);
    }

    @Override
    public Integer getWordCount(final String word)
    {
        final String ignoreCaseWord = word.toLowerCase();
        Integer count = 0;

        if (this.counter.containsKey(ignoreCaseWord))
        {
            count = this.counter.get(ignoreCaseWord);
        }

        return count;
    }

    @Override
    public List<String> getWordList()
    {
        return this.list;
    }
}
