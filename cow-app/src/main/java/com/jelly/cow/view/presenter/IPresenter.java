package com.jelly.cow.view.presenter;

import com.jelly.cow.view.activity.IActivity;

public interface IPresenter<T extends IActivity>
{
    void initializeWith(final T activity);

    void retain();

    T getActivity();
}
