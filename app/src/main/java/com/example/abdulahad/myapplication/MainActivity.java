package com.example.abdulahad.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText cnic;
    Button button;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DbHelper dbHelper = new DbHelper(this);
        name = findViewById(R.id.e1);
        email = findViewById(R.id.e3);
        cnic = findViewById(R.id.e2);
        button = findViewById(R.id.b1);
        search = findViewById(R.id.search);
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = dbHelper.insertData(name.getText().toString(),Integer.parseInt(cnic.getText().toString()),email.getText().toString());
                if(result)
                {
                    Toast.makeText(MainActivity.this, "Values Inserted Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Values Not Inserted Successfully, But Was Inserted At All", Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}