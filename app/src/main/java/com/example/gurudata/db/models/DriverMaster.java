package com.example.gurudata.db.models;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity
public class DriverMaster implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "driverName")
    public String driverName;
    @ColumnInfo(name = "contactno")
    public String contactno;
    @ColumnInfo(name ="address")
    public String address;
}
