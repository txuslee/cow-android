package com.jelly.cow.view.presenter;

import com.jelly.cow.view.activity.IMainActivity;

import java.io.IOException;


public interface IMainPresenter extends IPresenter<IMainActivity>
{
    void load(String uri) throws IOException;
}
