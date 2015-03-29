package com.jelly.cow.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jelly.cow.view.adapter.holder.WordViewHolder;

import java.util.List;


public class WordListAdapter extends BaseAdapter
{
    private final List<String> list;
    private final Context context;

    public WordListAdapter(final Context context, final List<String> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount()
    {
        return this.list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        WordViewHolder view;

        if (convertView == null)
        {
            convertView = LayoutInflater.from(this.context).inflate(android.R.layout.simple_list_item_2, null);
            view = new WordViewHolder(convertView);
            convertView.setTag(view);
        }
        else
        {
            view = (WordViewHolder) convertView.getTag();
        }

        view.update((String) this.getItem(position), "0");
        return convertView;
    }
}
