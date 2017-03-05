package com.example.matthewbrown.testapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

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


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + PANTRY_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FOOD_NAME + " TEXT,"
                + KEY_QUANTITY + " REAL" + KEY_DATE_PURCHASED + " TEXT" + KEY_DAYS_LEFT + " INTEGER" + ")";
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
}
