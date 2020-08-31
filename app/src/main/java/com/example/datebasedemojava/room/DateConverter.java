package com.example.datebasedemojava.room;

import androidx.room.TypeConverter;

import java.util.Date;

//创建自定义类型转唤器
public class DateConverter {

    @TypeConverter
    public long converterDate(Date value) {
        return value.getTime();
    }

    @TypeConverter
    public Date revertDate(long value) {
        return new Date(value);
    }
}
