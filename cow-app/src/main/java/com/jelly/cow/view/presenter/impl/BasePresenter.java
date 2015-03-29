package com.jelly.cow.view.presenter.impl;

import com.jelly.cow.view.activity.IActivity;
import com.jelly.cow.view.presenter.IPresenter;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<T extends IActivity> implements IPresenter<T>
{
    protected WeakReference<T> activity;

    protected BasePresenter()
    {
    }

    @Override
    public void initializeWith(final T activity)
    {
        this.activity = new WeakReference<T>(activity);
    }

    @Override
    public void retain()
    {
        this.activity.clear();
    }

    @Override
    public T getActivity()
    {
        return this.activity.get();
    }

}