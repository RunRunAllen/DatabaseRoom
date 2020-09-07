package com.example.datebasedemojava.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CustomTypeDao {
    @Query("select * from custom")
    List<CustomType> queryAll();

    @Insert
    void insertAll(CustomType... customTypes);

    //冲突的解决方案
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCustomType(CustomType customType);

    @Update
    void updateCustomType(CustomType... customTypes);

    @Delete
    void delete(CustomType customType);
}
