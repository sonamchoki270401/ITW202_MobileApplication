package com.example.todo_25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks, editTextId;
    Button btnAddData;
    Button btnViewAll;
    Button btnUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editName2);
        editMarks = findViewById(R.id.editMarks);
        editTextId = findViewById(R.id.editID);
        btnAddData = findViewById(R.id.button1);
        btnViewAll = findViewById(R.id.button2);
        btnUpdate = findViewById(R.id.button3);
        btnDelete = findViewById(R.id.button4);
    }

    public void AddData(View view) {
        boolean isInserted = myDb.insertData(editTextId.getText().toString(),
                editName.getText().toString(),
                editSurname.getText().toString(),
                editMarks.getText().toString());
        if (isInserted == true)
            Toast.makeText(MainActivity.this, "Data is inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data is not inserted",Toast.LENGTH_LONG).show();


    }
}