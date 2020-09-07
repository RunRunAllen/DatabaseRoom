package com.example.datebasedemojava.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "custom")
public class CustomType {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "custom_Id")
    private long customId;
    @ColumnInfo(name = "custom_name")
    private String name;
    @ColumnInfo(name = "custom_age")
    private String age;
    @ColumnInfo(name = "createDate")
    private Date createDate;


    public long getCustomId() {
        return customId;
    }

    public void setCustomId(long customId) {
        this.customId = customId;
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
