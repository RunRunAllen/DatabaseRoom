package com.example.datebasedemojava;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datebasedemojava.room.AppDatabase;
import com.example.datebasedemojava.room.User;
import com.example.datebasedemojava.room.UserDao;

public class MainActivity extends AppCompatActivity {

    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserDao = AppDatabase.getInstance(this).userDao();
        findViewById(R.id.tv_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initThread();
            }
        });

    }

    private void initThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    User user = new User();
                    user.setUserId("001" + i);
                    user.setName("哈哈" + i);
                    user.setAge("000" + i);
                    Log.i("haha","===i=="+i);
                    mUserDao.insertUsers(user);
                }
            }
        }).start();

    }
}