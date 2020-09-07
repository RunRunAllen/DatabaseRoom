package com.example.datebasedemojava.room;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import static com.example.datebasedemojava.room.Constant.DATABASE_NAME;

@Database(entities = {User.class, CustomType.class}, version = 3, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract CustomTypeDao customTypeDao();

    private static volatile AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        // addMigrations   设置数据库升级/降级操作
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                DATABASE_NAME)
                //在主线程中使用
                .allowMainThreadQueries()
//                .addMigrations(Migration_1_2)
//                .fallbackToDestructiveMigration()
                .addMigrations(Migration_2_3)
//                .addMigrations(Migration_5_6)

                .build();
    }

    static final Migration Migration_1_2 = new Migration(1, 2) {
        //1. startVersion表示的是升级开始的版本，endVersion表示要升级到的版本
        //2. 同时需要将 @Database 注解的version的值改为 endVersion

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //这里对表或者数据的操作， eg:复制，迁移 删除 修改表等
            //没有变换，做一个空实现
        }
    };
    static final Migration Migration_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE users ADD COLUMN other_name  TEXT");
        }
    };
//    static final Migration Migration_5_6 = new Migration(5, 6) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//
//            database.execSQL("create table temp_user ( id long primary key not null" +
//                    ",user_id text,user_name text,user_age text, custom_id long,other_name text,other_age text)");
//            database.execSQL("insert into temp_user (id ,user_id ,user_name,user_age,custom_id,other_name,other_age)" +
//                    "select id,user_id,user_name,user_age,custom_id,other_name,other_age from users");
//            database.execSQL("drop table users");
//            database.execSQL("alter table temp_user rename to users");
//
//        }
//    };
}
