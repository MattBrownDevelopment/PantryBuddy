package com.example.matthewbrown.testapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.*;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static com.example.matthewbrown.testapp.R.id.edit_text_item1;

public class DisplayMessageActivity extends AppCompatActivity {

    EditText mEdit;
    EditText mEdit2;
    EditText mEdit3;
    EditText mEdit4;
    EditText number1;
    EditText number2;
    EditText number3;
    EditText number4;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        TextView textView = new TextView(this);
        textView.setTextSize(40);

        mEdit = (EditText) findViewById(R.id.edit_text_item1);
        mEdit2 = (EditText) findViewById(R.id.edit_text_item2);
        mEdit3 = (EditText) findViewById(R.id.edit_text_item3);
        mEdit4 = (EditText) findViewById(R.id.edit_text_item4);
        number1 = (EditText) findViewById(R.id.itemQty1);
        number2 = (EditText) findViewById(R.id.itemQty2);
        number3 = (EditText) findViewById(R.id.itemQty3);
        number4 = (EditText) findViewById(R.id.itemQty4);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void submitList(View v) {
       // String filePath = getFilesDir() + "/data.txt";
       // File f = new File(filePath);
        // String FILENAME = "pantry";
        if (mEdit.getText().toString() != "") {
            FoodItem f1 = new FoodItem();
            f1.setItemName(mEdit.getText().toString());
            f1.setAmount((Double.valueOf(number1.getText().toString())));
            DatabaseHandler dbHandler = new DatabaseHandler(this);
            dbHandler.addFood(f1);
            //Now submit it to the Pantry
           /* String filepath = getFilesDir().toString();
            try {
                CSV_IO writer = new CSV_IO();
                writer.writeToFile(f1.getItemName(),Double.valueOf(f1.getAmount()).toString(),"","",filepath);

                writer.readFile(filepath); //Used for debugging for now
            }
            catch(IOException ex)
            {
                System.out.println("error");
                ex.printStackTrace();
            }
            */
        }
    }

    public void deleteDB(View v)
    {

    }


}


