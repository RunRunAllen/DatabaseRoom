package com.example.datebasedemojava.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("select * from students where student_id = (:id)")
    Student queryStudentzById(String id);

    @Query("select * from students")
    List<Student> queryAllStudent();

    @Insert
    void insert(Student student);
}
