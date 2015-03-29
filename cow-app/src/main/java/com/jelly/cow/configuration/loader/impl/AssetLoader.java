package com.jelly.cow.configuration.loader.impl;

import android.content.Context;
import android.content.res.AssetManager;

import com.jelly.cow.configuration.loader.IAssetLoader;

import java.io.IOException;
import java.io.InputStream;

public class AssetLoader implements IAssetLoader
{
    private final Context context;

    public AssetLoader(final Context context)
    {
        this.context = context;
    }

    @Override
    public InputStream load(final String uri) throws IOException
    {
        final AssetManager manager = this.context.getAssets();
        return manager.open(uri);
    }
}
