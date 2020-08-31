package com.example.datebasedemojava.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "custom_users")
public class CustomType {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "custom_name")
    private String name;
    @ColumnInfo(name = "custom_age")
    private String age;
    @ColumnInfo(name = "createDate")
    private Date createDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age == null ? "" : age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
