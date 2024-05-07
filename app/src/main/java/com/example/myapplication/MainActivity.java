package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button add;
    Button bt;
    String[] myArr = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.dela);
        add = findViewById(R.id.add);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment fragment = new BlankFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fr_del, fragment);
                ft.commit();

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fr_add fragment = new Fr_add();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fr_del, fragment);
                ft.commit();
            }
        });




        if(FirebaseAuth.getInstance().getCurrentUser()== null){
            startActivity(new Intent(MainActivity.this, Registr_Activity.class));
        }
    }

}