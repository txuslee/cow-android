package com.jelly.cow.view.adapter.holder;

import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WordViewHolder
{
    @InjectView(android.R.id.text1)
    TextView wordTextView;
    @InjectView(android.R.id.text2)
    TextView countTextView;

    public WordViewHolder(final View view)
    {
        ButterKnife.inject(this, view);
    }

    public void update(final String word, final String count)
    {
        this.wordTextView.setText(word);
        this.countTextView.setText(count);
    }
}
