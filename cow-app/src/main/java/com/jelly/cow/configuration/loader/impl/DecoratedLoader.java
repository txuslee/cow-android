package com.jelly.cow.configuration.loader.impl;


import com.jelly.cow.configuration.loader.ILoader;


abstract class DecoratedLoader<R, I> implements ILoader<R>
{
    protected final ILoader<I> loader;

    protected DecoratedLoader(final ILoader<I> loader)
    {
        this.loader = loader;
    }
}