package com.example.dtable.lurs2;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.icu.text.Replaceable;

import java.util.List;

@Dao
public interface ReviewDao {
    @Query("SELECT * FROM Review")
    List<Review> getAll();
    @Query("SELECT * FROM Review WHERE Location_Name=:name")
    List<Review> getWithName(String name);
    @Query("SELECT * FROM Review WHERE Category=:cat")
    List<Review> getWithCategory(String cat);
    @Query("SELECT * FROM Review WHERE Address=:add")
    List<Review> getWithAdress(String add);




    @Query("DELETE  FROM Review")
    void deleteAll();

    @Insert
    void insertAll(Review... review);

    @Update()
    void updateItem(Review review);



    @Delete
    void delete(Review review);

}
