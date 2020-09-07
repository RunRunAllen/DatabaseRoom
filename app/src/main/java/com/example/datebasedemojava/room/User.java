package com.example.datebasedemojava.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "users", foreignKeys = @ForeignKey(entity = CustomType.class, parentColumns = "custom_Id", childColumns = "id"))

@Entity(tableName = "users")

// 注解声明与唯一性
//根据访问数据的方式，您可能需要索引数据库中的某些字段以加快查询速度。若要向实体添加索引
//@Entity(indices = {@Index("user_id"),@Index(value = {""})})

public class User {
    //每个实体必须定义至少1个字段作为主键。即使只有1个字段，仍然需要用@PrimaryKey注解字段。此外，如果您想Room自动分配IDs给实体
    // ，则可以设置@ PrimaryKey的autoGenerate属性。如果实体具有复合主键，则可以使用@Entity注解的primaryKeys属性，如下面的代码片段所示：

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "user_id")
    private String userId;
    @ColumnInfo(name = "user_name")
    private String name;
    @ColumnInfo(name = "user_age")
    private String age;

    @ColumnInfo(name = "custom_Id")
    private long customId;

    @ColumnInfo(name = "other_name")
    private String otherName;
    @ColumnInfo(name = "other_age")
    private String otherAge;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId == null ? "" : userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public long getCustomId() {
        return customId;
    }

    public void setCustomId(long customId) {
        this.customId = customId;
    }

    public String getOtherName() {
        return otherName == null ? "" : otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getOtherAge() {
        return otherAge == null ? "" : otherAge;
    }

    public void setOtherAge(String otherAge) {
        this.otherAge = otherAge;
    }
}
