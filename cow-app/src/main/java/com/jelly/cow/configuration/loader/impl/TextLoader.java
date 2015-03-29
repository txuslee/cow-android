package com.jelly.cow.configuration.loader.impl;

import com.jelly.cow.configuration.loader.ILoader;
import com.jelly.cow.configuration.loader.ITextLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TextLoader extends DecoratedLoader<String, InputStream> implements ITextLoader
{
    public static final String DEFAULT_FILE_ENCODING = "UTF-8";
    public static final int DEFAULT_BUFFER_SIZE = 1024;

    private final String encoding;

    public TextLoader(final ILoader<InputStream> loader)
    {
        this(loader, DEFAULT_FILE_ENCODING);
    }

    public TextLoader(final ILoader<InputStream> loader, final String encoding)
    {
        super(loader);
        this.encoding = encoding;
    }

    @Override
    public String load(final String uri) throws IOException
    {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int length = 0;

        final InputStream is = this.loader.load(uri);
        while ((length = is.read(buffer)) != -1)
        {
            baos.write(buffer, 0, length);
        }
        return new String(baos.toByteArray(), this.encoding);
    }
}
