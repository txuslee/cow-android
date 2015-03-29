package com.jelly.cow.view.presenter.impl;

import com.jelly.cow.view.activity.IMainActivity;
import com.jelly.cow.view.presenter.IMainPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainPresenter extends BasePresenter<IMainActivity> implements IMainPresenter
{
    private final Map<String, Integer> counter;
    private final List<String> list;

    public MainPresenter()
    {
        this.counter = new HashMap<String, Integer>();
        this.list = new ArrayList<String>();
    }

    @Override
    public void initializeWith(final IMainActivity activity)
    {
        super.initializeWith(activity);
        activity.initializeList(this.list);
    }

    @Override
    public void startLoading()
    {
        final IMainActivity activity = this.getActivity();
        if (activity != null)
        {
            activity.startLoading();
        }
    }

    public void updateWordCount(final String word)
    {
        Integer count = this.getWordCount(word);
        this.counter.put(word.toLowerCase(), ++count);
        this.list.add(word);
    }

    @Override
    public void updateProgress(final String word)
    {
        this.updateWordCount(word);

        final IMainActivity activity = this.getActivity();
        if (activity != null)
        {
            activity.updateList();
        }
    }

    @Override
    public void stopLoading()
    {
        final IMainActivity activity = this.getActivity();
        if (activity != null)
        {
            activity.stopLoading();
        }
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
