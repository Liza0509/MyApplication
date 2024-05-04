package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.LinkedList;

public class MyMonthAdapter extends ArrayAdapter<MyTasks> {

    public MyMonthAdapter(Context context, LinkedList<MyTasks> arr) {
        super(context, R.layout.adapter_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyTasks month = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.textView)).setText(month.name);
        ((TextView) convertView.findViewById(R.id.textView2)).setText(String.valueOf(month.impr));
        ((TextView) convertView.findViewById(R.id.textView3)).setText(String.valueOf(month.rew));
// Выбираем картинку для месяца

        return convertView;
    }
}