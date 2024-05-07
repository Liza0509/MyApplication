package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registr_Activity extends AppCompatActivity {
    EditText email = findViewById(R.id.emailReg);
    EditText name = findViewById(R.id.nameReg);
    EditText password = findViewById(R.id.passwordReg);
    Button bt_reg = findViewById(R.id.bt_reg);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registr);
        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty() || name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"поля не должны быть пустыми", Toast.LENGTH_LONG).show();
                }else {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString());
                    HashMap<String, String> userInfo = new HashMap<>();
                    userInfo.put("email", email.getText().toString());
                    userInfo.put("name", name.getText().toString());
                    FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(userInfo);

                    startActivity(new Intent(Registr_Activity.this, MainActivity.class));
                }
            }
        });

    }
}