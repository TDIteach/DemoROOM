package com.chakoujmed.demoroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IGestionUtilisateurs {
    @Insert
    public void AjouterUtilisateur(User e);
    @Update
    public  void ModifierUtilisateur(User e);
    @Delete
    public  void Supprimer(User e);
    @Query("select * from user")
    public  List<User> getUsers();
}
