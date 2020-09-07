package com.example.datebasedemojava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datebasedemojava.room.AppDatabase;
import com.example.datebasedemojava.room.Student;
import com.example.datebasedemojava.room.StudentDao;
import com.example.datebasedemojava.room.StudentData;
import com.example.datebasedemojava.room.User;
import com.example.datebasedemojava.room.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private UserDao mUserDao;
    private TextView mQuery;
    private TextView mInsert;
    private TextView mDelete;
    private TextView mUpdate;
    private StudentDao mStudentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuery = findViewById(R.id.tv_query);
        mInsert = findViewById(R.id.tv_insert);
        mDelete = findViewById(R.id.tv_delete);
        mUpdate = findViewById(R.id.tv_update);
        mQuery.setOnClickListener(this);
        mInsert.setOnClickListener(this);
        mDelete.setOnClickListener(this);
        mUpdate.setOnClickListener(this);
        mUserDao = AppDatabase.getInstance(this).userDao();
        mStudentDao = AppDatabase.getInstance(this).studentDao();

    }

    private void initInsert() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                User user = new User();
                user.setUserId("000");
                user.setName("哈哈");
                user.setAge("000");
                user.setCustomId(0);
                mUserDao.insertUsers(user);

//                Student student = new Student();
//                student.setName("小明");
//                student.setStudentId(000);
//                StudentData studentData = new StudentData();
//                studentData.setStudentAge("11");
//                student.setStudentData(studentData);
//                mStudentDao.insert(student);


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mInsert.setText("插入成功!");
                    }
                });
            }
        }).start();

    }

    private void initUpdate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = mUserDao.queryById("0010");
                user.setName("啦啦啦啦啦");
                mUserDao.updateUsers(user);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mUpdate.setText("更新成功!");
                    }
                });
            }
        }).start();

    }

    private void initQuery() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                final List<User> listUser = mUserDao.queryAll();

//                final List<Student> students = mStudentDao.queryAllStudent();
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mQuery.setText("查询共:" + students.size() + "个" + "===第一个是" + students.get(0).getStudentData().getStudentAge());
//                    }
//                });
            }
        }).start();

    }

    private void initDelete() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<User> users = mUserDao.queryAll();
                mUserDao.delete(users.get(0));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mDelete.setText("删除：" + users.get(0).getName());
                    }
                });
            }
        }).start();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_insert:
                initInsert();
                break;
            case R.id.tv_delete:
//                initDelete();
                break;
            case R.id.tv_update:
//                initUpdate();
                break;
            case R.id.tv_query:
                initQuery();
                break;
        }
    }
}