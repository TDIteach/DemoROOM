package com.chakoujmed.demoroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public  int id;
    @ColumnInfo(name = "Name")
    public String userName;
    public String passWord;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
