package com.example.app_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mySF;
    SharedPreferences.Editor editorSF;

    EditText editTextSF;
    Button btnSave, btnAccess, btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySF = getApplicationContext().getSharedPreferences("myToken", 0);
        editorSF = mySF.edit();

        editTextSF = (EditText) findViewById(R.id.editTextSF);
        btnSave = (Button) findViewById(R.id.btnSaveSF);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editTextSF.getText().toString();
                editorSF.putString("Token1", s);
                editorSF.commit();
                Toast.makeText(MainActivity.this,"SF Token1 bernilai " + s + " disimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }

        public void actionAccessSF(View v) {
            String s = mySF.getString("Token1", null);
            if (s != null)
                Toast.makeText(MainActivity.this,"Mengakses SF Token1 " + s, Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"SF Token1 tidak ada " + s, Toast.LENGTH_SHORT).show();
        }

        public void actionRemoveSF(View v) {
            // TODO
            editorSF.remove("Token1");
            editorSF.commit();
            Toast.makeText(MainActivity.this,"Menghapus SF Token1", Toast.LENGTH_SHORT).show();
        }

        public void actionGoToActivity2(View v) {
            Intent i = new Intent(MainActivity.this, NextActivity.class);
            startActivity(i);
        }
}