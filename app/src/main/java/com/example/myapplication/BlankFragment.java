package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

public class BlankFragment extends Fragment {
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private LinkedList<MyTasks> DTasks;
    FirebaseDatabase fb_db;
    LinkedList<MyTasks> arr;
    DatabaseReference dbr;
    ArrayAdapter<MyTasks> monthAdapter;

    ListView lv;
    String[] myArr = { "12", "34", "56", "78", "90"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arr = new LinkedList<>();
        //lv = lv.findViewById(R.id.list);
    }
    LinkedList<MyTasks> makeMonth() {
        String name;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String userId = user.getUid();
        dbr = FirebaseDatabase.getInstance("https://frbs-1971e-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("dela").child(userId);
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds :snapshot.getChildren()) {
                    if (ds == null) { break;} else {
                        String name = ds.child("name").getValue(String.class);
                        String sroki = ds.child("sroki").getValue(String.class);
                        String nagrada = ds.child("nagrada").getValue(String.class);


                        MyTasks tasks = new MyTasks();
                        tasks.nagrada = "награда: " + nagrada;
                        tasks.sroki = "сроки: " + sroki;
                        tasks.name = "имя: " + name;
                        arr.add(tasks);
                        monthAdapter.notifyDataSetInvalidated();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        return arr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View res = inflater.inflate(R.layout.fragment_blank, container, false);
        monthAdapter =
                new arAdapter(getContext(), arr);
        lv = res.findViewById(R.id.list);
        lv.setAdapter(monthAdapter);
        makeMonth();

        return res;
    }
}