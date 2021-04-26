package com.example.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {
 private EditText OWebsite;
 private EditText OLocation;
 private EditText shareLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OWebsite = findViewById(R.id.editText1);
        OLocation = findViewById(R.id.editText2);
        shareLink = findViewById(R.id.editText3);
    }

    public void website(View view) {
        String websiteTxt = OWebsite.getText().toString();
        Uri url = Uri.parse(websiteTxt);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager()) !=null)
        {
            startActivity(intent);
        }
        else{
            Log.d("Implicit Intent","ERROR!");
        }
    }

    public void location(View view) {
        String locationTxt = OLocation.getText().toString();
        Uri locUrl = Uri.parse("geo:0,0?q="+locationTxt);
        Intent intent = new Intent(Intent.ACTION_VIEW, locUrl);
        if(intent.resolveActivity(getPackageManager()) !=null)
        {
            startActivity(intent);
        }
        else{
            Log.d("Implicit Intent","ERROR!");
        }
    }

    public void share(View view) {
        String shareTxt = shareLink.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(shareTxt)
                .startChooser();
    }



}