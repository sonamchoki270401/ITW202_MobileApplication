package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    public void donut(View view) {
        displayToast(getString(R.string.donutMessage));
    }

    public void icecream(View view) {
        displayToast(getString(R.string.IcecreamMessage));
    }

    public void froyo(View view) {
        displayToast(getString(R.string.FroyoMessage));
    }

    public void call(View view) {
        Uri uri = Uri.parse("tel:17983097");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
}