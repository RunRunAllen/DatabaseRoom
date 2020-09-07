package com.example.datebasedemojava.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from users")
    List<User> queryAll();

    @Query("select * from users where user_id in (:userIds)")
    List<User> queryAllByIds(String[] userIds);

    @Insert
    void insertAll(User... users);

    //冲突的解决方案
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(User users);

    @Update(onConflict = OnConflictStrategy.REPLACE )
    void updateUsers(User... users);

    @Delete
    void delete(User user);

}
