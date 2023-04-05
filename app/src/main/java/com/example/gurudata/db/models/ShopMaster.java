package com.example.gurudata.db.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class ShopMaster implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "shopname")
    public String shopname;
    @ColumnInfo(name = "contactno")
    public String contactno;
    @ColumnInfo(name ="address")
    public String address;




}
