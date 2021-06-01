package com.example.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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
            Toast.makeText(MainActivity.this, "Data is inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data is not inserted", Toast.LENGTH_LONG).show();


    }

    public void ViewOn(View view) {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            //show message
            showMessage("Error", "Nothing Found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Student_id :" + res.getString(0) + "\n");
            buffer.append("First Name :" + res.getString(1) + "\n");
            buffer.append("Last Name :" + res.getString(2) + "\n");
            buffer.append("ITW202 MARKS :" + res.getString(3) + "\n \n");
        }
        showMessage("List of Students", buffer.toString());
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void Update(View view) {
        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                editName.getText().toString(),
                editSurname.getText().toString(),
                editMarks.getText().toString());
        if (isUpdate == true)
            Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data is not Updated", Toast.LENGTH_LONG).show();

    }

    public void Delete(View view) {
       Integer deleteRows = myDb.deleteData(editTextId.getText().toString());
        if (deleteRows > 0)
            Toast.makeText(MainActivity.this, "Data Delete", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data  not Delete", Toast.LENGTH_LONG).show();

    }
}