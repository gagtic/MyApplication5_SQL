package com.example.abdulahad.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText cnic;
    Button search;
    TextView name;
    TextView email;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cnic = findViewById(R.id.cnic);
        search = findViewById(R.id.search);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        dbHelper = new DbHelper(this);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbHelper.GetInformation(cnic.getText().toString());
                while(cursor.moveToNext())
                {
                    name.setText(cursor.getString(1));
                    email.setText(cursor.getString(3));
                }
            }
        });
    }
}
