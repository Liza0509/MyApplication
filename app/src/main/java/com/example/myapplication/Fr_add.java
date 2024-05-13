package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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
        EditText edname =  view.findViewById(R.id.name);
        EditText edsroki =  view.findViewById(R.id.sroki);
        EditText ednagrada =  view.findViewById(R.id.nagrada);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //HashMap <String, String> hashDelo = new HashMap<>();
                //hashDelo.put("name", edname.getText().toString());
                //hashDelo.put("sroki", edsroki.getText().toString());
                //hashDelo.put("nagrada", ednagrada.getText().toString());
//
                //FirebaseDatabase.getInstance().getReference().child("dela").
                //child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(hashDelo);


                FirebaseDatabase database =  FirebaseDatabase.getInstance();
                FirebaseUser user =  FirebaseAuth.getInstance().getCurrentUser();
                String userId = user.getUid();
                DatabaseReference mRef =  database.getReference().child("dela").child(userId).push();
                mRef.child("name").setValue(edname.getText().toString());
                mRef.child("sroki").setValue(edsroki.getText().toString());
                mRef.child("nagrada").setValue(ednagrada.getText().toString());
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Сообщение из фрагмента", Toast.LENGTH_LONG).show();
            }
        });
        return view;


    }
}
