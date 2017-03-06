package com.example.matthewbrown.testapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MatthewBrown on 3/4/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "FoodStorageDB";

    // Contacts table name
    private static final String PANTRY_TABLE = "Pantry";

    // Contacts Table Columns names
    private static final String KEY_ID = "_id";
    private static final String KEY_FOOD_NAME = "_foodName";
    private static final String KEY_QUANTITY = "_quantity";
    private static final String KEY_DATE_PURCHASED = "_dateBought";
    private static final String KEY_DAYS_LEFT = "_daysLeft";
    private static final String KEY_USAGE_PERDAY = " _usagePerDay";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + PANTRY_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FOOD_NAME + " TEXT,"
                + KEY_QUANTITY + " REAL" + KEY_DATE_PURCHASED + " TEXT" + KEY_DAYS_LEFT + " INTEGER" + KEY_USAGE_PERDAY + " REAL"
        + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + PANTRY_TABLE);

        // Create tables again
        onCreate(db);
    }

    public void addFood(FoodItem foodItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOOD_NAME, foodItem.getItemName()); // Food Name
        values.put(KEY_QUANTITY, foodItem.getAmount());
        //TODO: Implement the date functionality.
     //   values.put(KEY_DATE_PURCHASED, foodItem.getAmount());
       // values.put(KEY_USAGE_PERDAY, foodItem.getAmount());

        // Inserting Row
        db.insert(PANTRY_TABLE, null, values);
        db.close(); // Closing database connection
    }


    public FoodItem getFoodItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(PANTRY_TABLE, new String[] { KEY_ID,
                        KEY_FOOD_NAME, KEY_QUANTITY }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        FoodItem f1 = new FoodItem( Integer.parseInt(cursor.getString(0)), (cursor.getString(1)), Double.valueOf((cursor.getString(2))));
        return f1;
    }

    public ArrayList<FoodItem> getAllFoods() {
        ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + PANTRY_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FoodItem f1 = new FoodItem();
                f1.setID(Integer.parseInt(cursor.getString(0)));
                f1.setItemName(cursor.getString(1));
                f1.setAmount(Double.valueOf(cursor.getString(2)));
                // Adding contact to list
                foodList.add(f1);
            } while (cursor.moveToNext());
        }

        // return contact list
        return foodList;
    }

    //Total number of items in the DB
    public int getFoodCount() {
        String countQuery = "SELECT  * FROM " + PANTRY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public int updateItem(FoodItem f1) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOOD_NAME, f1.getItemName());
        values.put(KEY_QUANTITY, f1.getAmount());

        // updating row
        return db.update(PANTRY_TABLE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(f1.getID()) });
    }


    public void deleteContact(FoodItem contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(PANTRY_TABLE, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }

    public void test()
    {
    int x = 5;
    System.out.println(x);
    System.out.println("hello");
        System.out.println("where is github putting things");
        System.out.println("test");
    }

}
