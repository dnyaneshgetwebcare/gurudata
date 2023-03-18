package com.example.gurudata.db;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;


public class DatabaseApplication {
    private Context mCtx;
    private static DatabaseApplication mInstance;

    AppDatabase myDatabase;
    private DatabaseApplication(Context mCtx) {
        this.mCtx=mCtx;

        myDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, AppDatabase.NAME).allowMainThreadQueries().build();
    }
    public static synchronized DatabaseApplication getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseApplication(mCtx);
        }
        return mInstance;
    }
    public AppDatabase getMyDatabase() {
        return myDatabase;
    }


}
