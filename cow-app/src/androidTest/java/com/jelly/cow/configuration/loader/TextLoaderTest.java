package com.jelly.cow.configuration.loader;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import com.jelly.cow.configuration.loader.impl.AssetLoader;
import com.jelly.cow.configuration.loader.impl.TextLoader;

import java.io.IOException;


public class TextLoaderTest extends InstrumentationTestCase
{
    private TextLoader sut;

    @Override
    public void setUp() throws Exception
    {
        final Context context = getInstrumentation().getContext();
        this.sut = new TextLoader(new AssetLoader(context));
    }

    @MediumTest
    public void test_load_whenFileDoesNotExist_throwsException() throws Exception
    {
        try
        {
            this.sut.load("not_exists.txt");
            fail("Expected exception");
        }
        catch (IOException e)
        {
        }
    }

    @MediumTest
    public void test_load_whenFileExists_returnsFileContents() throws Exception
    {
        final String actual = this.sut.load("lipsum.txt");
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", actual);
    }
}