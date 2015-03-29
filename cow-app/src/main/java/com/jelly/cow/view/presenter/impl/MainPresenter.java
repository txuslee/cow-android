package com.jelly.cow.view.presenter.impl;

import com.jelly.cow.configuration.loader.ITextLoader;
import com.jelly.cow.view.activity.IMainActivity;
import com.jelly.cow.view.presenter.IMainPresenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainPresenter extends BasePresenter<IMainActivity> implements IMainPresenter
{
    private final List<String> list;
    private final ITextLoader loader;

    public MainPresenter(final ITextLoader loader)
    {
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
                this.list.add(word);

                final IMainActivity activity = this.getActivity();
                if (activity != null)
                {
                    activity.updateList();
                }
            }
        }
    }
}
