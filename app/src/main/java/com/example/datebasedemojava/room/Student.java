package com.example.datebasedemojava.room;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

@Entity(tableName = "students")
public class Student {
    @PrimaryKey
    @ColumnInfo(name = "student_id")
    private long studentId;
    @ColumnInfo(name = "student_name")
    private String name;

    //嵌套对象
    @Embedded
    public StudentData studentData;

    //TODO:
//    @Relation(parentColumn = "student_id",entityColumn = "user_id",entity = User.class)

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentData getStudentData() {
        return studentData;
    }

    public void setStudentData(StudentData studentData) {
        this.studentData = studentData;
    }
}
