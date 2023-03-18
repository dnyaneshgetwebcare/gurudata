package com.example.gurudata.db;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.gurudata.db.models.DriverMaster;
import com.example.gurudata.db.models.DriverMasterDao;

@Database(entities = {DriverMaster.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String NAME = "gurudatta";

    public abstract DriverMasterDao driverMasterDao();
    private static volatile AppDatabase appDatabase;

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }



    @Override
    public void clearAllTables() {

    }
}
