package com.jelly.cow.view.activity;

import java.util.List;

public interface IMainActivity extends IActivity
{
    void initializeList(final List<String> list);

    void startLoading();

    void updateList();

    void stopLoading();
}
