package com.example.app_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    SharedPreferences mySF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mySF = getApplicationContext().getSharedPreferences("myToken", 0);
    }

    public void actionAccessSF(View v) {
        String s = mySF.getString("Token1", null);
        if (s != null)
            Toast.makeText(MainActivity3.this,"Mengakses SF Token1 " + s, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"SF Token1 tidak ada " + s, Toast.LENGTH_SHORT).show();
    }
}