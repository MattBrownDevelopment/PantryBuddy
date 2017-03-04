package com.example.matthewbrown.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewPantry extends AppCompatActivity {
    EditText mEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pantry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEdit = (EditText) findViewById(R.id.editText5);

    }

    public void loadPantry(View v) {
        File f = new File(getFilesDir().toString() + "/data.txt");
        try {
            FileInputStream fIn = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[10000];
            isr.read(inputBuffer);
            String readString = new String(inputBuffer);
            mEdit.setText(readString);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}


