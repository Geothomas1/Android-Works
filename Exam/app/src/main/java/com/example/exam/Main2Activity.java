package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
EditText e1,e2,e3;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText4);
        e3 = (EditText) findViewById(R.id.editText5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passvalue();
            }
        });
    }
        public void passvalue(){
            String name = e1.getText().toString();
            String dep = e2.getText().toString();
            String rollno = e3.getText().toString();

            SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("name", name);
            editor.putString("dep",dep);
            editor.putString("rollno",rollno);
            editor.apply();
            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(intent);
        }

}


