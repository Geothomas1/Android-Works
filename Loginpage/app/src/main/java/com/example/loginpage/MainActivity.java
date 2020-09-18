package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user_name, password,password2;
    private Button sign_in, view;
    TextView t1;
    final Database db = new Database(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = user_name.getText().toString();
                String b = password.getText().toString();
                String c=password2.getText().toString();
                if (a.isEmpty() || b.isEmpty()||c.isEmpty())
                    Toast.makeText(MainActivity.this, "Fields are empty",
                            Toast.LENGTH_SHORT).show();
                else {
                    if(b.equals(c)){
                        if(check()){
                            db.insertValues(a, b);
                            Toast.makeText(MainActivity.this, "Registered Successfully ", Toast.LENGTH_SHORT).show();
                        }
                        else Toast.makeText(MainActivity.this, "Username  already exist", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(MainActivity.this, "passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getAllData();
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("name:" + res.getString(0) + "\n");
                    buffer.append("password:" + res.getString(1) + "\n");
                }
                Toast.makeText(MainActivity.this, buffer,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean check(){
        String a = user_name.getText().toString();
        Cursor res = db.CheckAllData(a);
        boolean flag=true;
        while (res.moveToNext()) {
            flag=false;
        }
        return flag;
    }
    private void setupUIViews() {
        user_name = findViewById(R.id.editText);
        password = findViewById(R.id.editText3);
        password2=findViewById(R.id.editText4);
        sign_in = findViewById(R.id.button);
        view = findViewById(R.id.button2);
    }

}
