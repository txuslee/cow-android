package com.jelly.cow.view.presenter;

import com.jelly.cow.view.activity.IMainActivity;

import java.io.IOException;
import java.util.List;


public interface IMainPresenter extends IPresenter<IMainActivity>
{
    void load(final String uri) throws IOException;

    Integer getWordCount(final String word);

    List<String> getWordList();
}
