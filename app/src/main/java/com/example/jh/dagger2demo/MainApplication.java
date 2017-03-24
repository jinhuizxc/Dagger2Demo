package com.example.jh.dagger2demo;

import android.app.Application;

import com.example.jh.dagger2demo.dagger2.component.AComponent;
import com.example.jh.dagger2demo.dagger2.component.ApplicationComponent;
import com.example.jh.dagger2demo.dagger2.component.DaggerApplicationComponent;
import com.example.jh.dagger2demo.dagger2.modules.AModule;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 */

public class MainApplication extends Application {

    private ApplicationComponent mApplicationComponent;
    private AComponent mAComponent;
    private static MainApplication sApplication;

    public static MainApplication getInstance() {
        return sApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

        mApplicationComponent = DaggerApplicationComponent.builder()
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public AComponent getAComponent() {
        if (mAComponent == null){
            mAComponent = mApplicationComponent.plus(new AModule());
        }
        return mAComponent;
    }
}
