package com.jelly.cow.configuration.loader;

import java.io.IOException;

public interface ILoader<R>
{
    R load(final String uri) throws IOException;
}
