package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fr_add extends Fragment {
    EditText name;
    EditText sroki;
    EditText nagrada;
    @Override
    // Переопределяем метод onCreateView
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // менеджер компоновки, который позволяет
        // получать доступ к layout с наших ресурсов
        View view = inflater
                .inflate(R.layout.fr_add, container, false);

        // теперь можем достучаться до наших элементов, расположенных во
        // фрагменте

        Button back = view.findViewById(R.id.back);
        Button ok = view.findViewById(R.id.ok);
        EditText name =  view.findViewById(R.id.name);
        EditText sroki =  view.findViewById(R.id.sroki);
        EditText nagrada =  view.findViewById(R.id.nagrada);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Сообщение из фрагмента", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
