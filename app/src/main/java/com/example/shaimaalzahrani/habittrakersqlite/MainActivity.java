package com.example.shaimaalzahrani.habittrakersqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitTDBHelper db = new HabitTDBHelper(this);
        Log.d("Status: ", "DB created");

        // Inserting Rows

        db.addHabit(new Habit("running", 0));
        db.addHabit(new Habit("taking nap", 1));
        db.addHabit(new Habit("calling my mother" , 1));
        db.addHabit(new Habit("Go to bed", 0));

        Log.d("Status: ", "values inserted");

        List<Habit> habits = db.getAllHabits();

        Log.d("Status: ", "List Created");

        for (Habit habit : habits) {
            String status;
            if(habit.getStatus() == 1){ status = "Done";}
            else status = "Not Done";

            String outString = "Id: " + habit.getId() + " ,Name: " + habit.getName() + " ,Status: " + status;
            // Writing shops  to log
            Log.d("Habit: : ", outString);
        }
    }
}
