package com.jelly.cow.view.presenter;

import com.jelly.cow.view.activity.IMainActivity;

import java.util.List;


public interface IMainPresenter extends IPresenter<IMainActivity>
{
    Integer getWordCount(final String word);

    List<String> getWordList();

    void startLoading();

    void updateProgress(String word);

    void stopLoading();

}
