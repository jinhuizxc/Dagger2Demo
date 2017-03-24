package com.example.jh.dagger2demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.jh.dagger2demo.Poetry;
import com.example.jh.dagger2demo.R;
import com.example.jh.dagger2demo.dagger2.component.MainComponent;
import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * 本demo测试Dagger2的使用
 *
 * 自定义@Scope注解，标记当前生成对象的使用范围，标识一个类型的注射器只实例化一次，
 * 在同一个作用域内，只会生成一个实例，然后在此作用域内共用一个实例。
 * 这样看起来很像单例模式，我们可以查看@Singleton其实就是@Scope的一个默认实现而已。
 */
public class MainActivity extends AppCompatActivity {

    //添加@Inject注解，表示这个mPoetry是需要注入的
    @Inject
    Poetry mPoetry;
    @Inject
    Gson mGson;

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 先运行一遍，AS会生成一些类，
         * 再修改一下MainActivity:
         */
        // 使用Dagger2生成的类 生成组件进行构造，并注入
        MainComponent.getInstance()
                .inject(this);

        initView();

       findViewById(R.id.open).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, OtherActivity.class));
           }
       });

    }

    private void initView() {
        textView1 = (TextView) findViewById(R.id.textView);
        String json = mGson.toJson(mPoetry);
        String text = json + ",mPoetry:"+mPoetry;
        textView1.setText(text);
    }
}
