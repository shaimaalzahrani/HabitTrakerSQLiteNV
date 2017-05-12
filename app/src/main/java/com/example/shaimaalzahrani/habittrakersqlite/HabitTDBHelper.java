package com.example.shaimaalzahrani.habittrakersqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaimaalzahrani on 08/05/2017.
 */

public class HabitTDBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Habits.db";

    public HabitTDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + HabitTDBContract.FeedEntry.TABLE_NAME + "("
                + HabitTDBContract.FeedEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY, "
                + HabitTDBContract.FeedEntry.COLUMN_NAME_NAME + " TEXT, "
                + HabitTDBContract.FeedEntry.COLUMN_NAME_STATUS + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + HabitTDBContract.FeedEntry.TABLE_NAME);
        // Creating tables again
        onCreate(db);
    }

    // Adding new habit
    public void addHabit(Habit habit) {
        Log.d("Status: ", "inside add");
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("Status: ", "after writable");
        ContentValues values = new ContentValues();
        values.put(HabitTDBContract.FeedEntry.COLUMN_NAME_NAME, habit.getName()); // habit Name
        values.put(HabitTDBContract.FeedEntry.COLUMN_NAME_STATUS, habit.getStatus()); // habit Status
        Log.d("Status: ", "after value creation");
        // Inserting Row
        db.insert(HabitTDBContract.FeedEntry.TABLE_NAME, null, values);
        db.close(); // Closing database connection

    }

    // Getting All Habits
    public List<Habit> getAllHabits() {
        List<Habit> habitList = new ArrayList<Habit>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + HabitTDBContract.FeedEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Habit habit = new Habit();
                habit.setId(Integer.parseInt(cursor.getString(0)));
                habit.setName(cursor.getString(1));
                habit.setSatus(cursor.getInt(2));
                // Adding contact to list
                habitList.add(habit);
            } while (cursor.moveToNext());
        }

        // return contact list
        return habitList;
    }
}
