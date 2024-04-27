package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.LinkedList;

public class BlankFragment extends Fragment {
    ListView lv;
    String[] myArr = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //lv = lv.findViewById(R.id.list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View res = inflater.inflate(R.layout.fragment_blank, container, false);

        lv = res.findViewById(R.id.list);
        ArrayAdapter<String> monthAdapter =
                new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, myArr);

        lv.setAdapter(monthAdapter);

        MyMonthAdapter adapter = new MyMonthAdapter(getContext(), makeMonth());
        ListView lv = res.findViewById(R.id.list);
        lv.setAdapter(adapter);
        return res;
    }

    LinkedList<MyMonth> makeMonth() {
        LinkedList<MyMonth> arr = new LinkedList();

// Названия месяцев
        String[] name = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
// Среднесуточная температура
        double[] impr = {-12.7, -11.3, -4.5, 7.7, 19.3, 23.9, 23.5, 22.8, 16.0, 5.2, -0.3, -9.3};
// Количество дней
        int[] dayArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

// Сборка месяцев
        for (int i = 0; i < name.length; i++) {
            MyMonth month = new MyMonth();
            month.name = name[i];
            month.impr = impr[i];
            month.rew = dayArr[i];
            arr.add(month);
        }
        return arr;
    }


}