package com.example.datebasedemojava;

import android.app.Application;

public class App extends Application {

    private static App instance;

    // 单例模式获取唯一的MyApplication
    public static App getInstance() {
        if (null == instance) {
            instance = new App();
        }/**/
        return instance;
    }
}
