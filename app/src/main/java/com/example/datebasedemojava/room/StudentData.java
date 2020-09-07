package com.example.datebasedemojava.room;

import androidx.room.ColumnInfo;

//嵌套表
public class StudentData {
    @ColumnInfo(name = "student_age")
    private String studentAge;

    public String getStudentAge() {
        return studentAge == null ? "" : studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }
}
