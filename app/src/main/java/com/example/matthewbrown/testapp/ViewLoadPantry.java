package com.example.matthewbrown.testapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewLoadPantry extends ListActivity {

    static ArrayList<FoodItem> foods;

    static String[] allFoods = new String[] {};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHandler dbHandler = new DatabaseHandler(this);
        foods = dbHandler.getAllFoods();
        System.out.println(foods.size());
        for(int i = 1; i < foods.size(); i++)
        {
            allFoods[i] = foods.get(i).getItemName() + foods.get(i).getAmount();
        }

        // no more this
        // setContentView(R.layout.list_fruit);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_fruit,allFoods));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
