package com.example.gurudata.db.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShopMasterDao {

    @Query("SELECT * FROM shopmaster")
    List<ShopMaster> getAll();

    @Query("SELECT * FROM shopmaster WHERE id IN (:userIds)")
    List<ShopMaster> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM shopmaster WHERE shopname LIKE :name  " +
            "LIMIT 1")
    ShopMaster findByName(String name);

    @Query("SELECT * FROM shopmaster")
    public ShopMaster[] loadAllDriverName();

    @Query("SELECT shopname FROM shopmaster")
    public String[] getName();
    @Insert
    void insertAll(ShopMaster shopMaster);

    @Delete
    void delete(ShopMaster shopMaster);
}
