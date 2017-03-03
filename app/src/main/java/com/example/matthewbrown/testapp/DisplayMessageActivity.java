package com.example.matthewbrown.testapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.*;

import java.io.FileOutputStream;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        TextView textView = new TextView(this);
        textView.setTextSize(40);

        mEdit = (EditText)findViewById(R.id.edit_text_item1);
        mEdit2 = (EditText)findViewById(R.id.edit_text_item2);
        mEdit3 = (EditText)findViewById(R.id.edit_text_item3);
        mEdit4 =(EditText)findViewById(R.id.edit_text_item4);
        number1 = (EditText)findViewById(R.id.itemQty1);
        number2 = (EditText)findViewById(R.id.itemQty2);
        number3 = (EditText)findViewById(R.id.itemQty3);
        number4 = (EditText)findViewById(R.id.itemQty4);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }

    public void submitList(View v)
    {
       // String FILENAME = "pantry";
        if(mEdit.getText().toString() != "") {
            FoodItem f1 = new FoodItem();
            f1.setItemName(mEdit.getText().toString());
            f1.setAmount((Double.valueOf(number1.getText().toString())));
            //Now submit it to the Pantry
        }

        //TODO: It crashes down here for some reason
       if(mEdit2.getText().toString() != "") {
            FoodItem f2 = new FoodItem();
            f2.setItemName(mEdit2.getText().toString());
            f2.setAmount((Double.valueOf(number2.getText().toString())));
            //Now submit it to the Pantry
        }
        if(mEdit3.getText().toString() != "") {
            FoodItem f3 = new FoodItem();
            f3.setItemName(mEdit3.getText().toString());
            f3.setAmount((Double.valueOf(number3.getText().toString())));
            //Now submit it to the Pantry
        }
        if(mEdit4.getText().toString() != "") {
            FoodItem f4 = new FoodItem();
            f4.setItemName(mEdit.getText().toString());
            f4.setAmount((Double.valueOf(number4.getText().toString())));
            //Now submit it to the Pantry
        }


    }
}
