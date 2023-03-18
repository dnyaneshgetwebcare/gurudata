package com.example.gurudata.db.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DriverMasterDao {

    @Query("SELECT * FROM drivermaster")
    List<DriverMaster> getAll();

    @Query("SELECT * FROM drivermaster WHERE id IN (:userIds)")
    List<DriverMaster> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM drivermaster WHERE driverName LIKE :name  " +
            "LIMIT 1")
    DriverMaster findByName(String name);

    @Query("SELECT * FROM drivermaster")
    public DriverMaster[] loadAllDriverName();

    @Query("SELECT driverName FROM drivermaster")
    public String[] getName();
    @Insert
    void insertAll(DriverMaster driverMaster);

    @Delete
    void delete(DriverMaster user);
}
