package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.LinkedList;

public class arAdapter extends ArrayAdapter<MyTasks> {

    public arAdapter(Context context, LinkedList<MyTasks> arr) {
        super(context, R.layout.adapter_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyTasks month = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        }

// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.textView9)).setText(month.name);
        ((TextView) convertView.findViewById(R.id.textView13)).setText(String.valueOf(month.nagrada));
        ((TextView) convertView.findViewById(R.id.textView14)).setText(String.valueOf(month.sroki));

// Выбираем картинку для месяца

        return convertView;
    }
}