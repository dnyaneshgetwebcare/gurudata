package com.example.gurudata.db;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.gurudata.db.models.DriverMaster;
import com.example.gurudata.db.models.DriverMasterDao;
import com.example.gurudata.db.models.ShopMaster;
import com.example.gurudata.db.models.ShopMasterDao;

@Database(entities = {DriverMaster.class, ShopMaster.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String NAME = "gurudatta";

    public abstract DriverMasterDao driverMasterDao();
    public abstract ShopMasterDao shopMasterDao();
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
