package com.example.shaimaalzahrani.habittrakersqlite;

import android.provider.BaseColumns;

/**
 * Created by shaimaalzahrani on 08/05/2017.
 */

public class HabitTDBContract {

        // To prevent someone from accidentally instantiating the contract class,
        // make the constructor private.
        private HabitTDBContract() {}

        /* Inner class that defines the table contents */
        public static class FeedEntry implements BaseColumns {
            public static final String TABLE_NAME = "hapits";
            public static final String COLUMN_NAME_ID = "id";
            public static final String COLUMN_NAME_NAME = "name";
        }
}