package com.example.datebasedemojava.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import static com.example.datebasedemojava.room.Constant.DATABASE_NAME;

@Database(entities = {User.class, CustomType.class}, version = 1, exportSchema = false)
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
                .build();

//                .addMigrations(new Migration(1, 2) {
//            //1. startVersion表示的是升级开始的版本，endVersion表示要升级到的版本
//            //2. 同时需要将 @Database 注解的version的值改为 endVersion
//            @Override
//            public void migrate(@NonNull SupportSQLiteDatabase database) {
//                //这里对表或者数据的操作， eg:复制，迁移 删除 修改表等
//                database.execSQL("ALTER TABLE users RENAME TO user");
//            }
//        }).build();

    }
}
