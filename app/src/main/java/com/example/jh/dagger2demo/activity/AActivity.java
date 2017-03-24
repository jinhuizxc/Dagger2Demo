package com.example.jh.dagger2demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jh.dagger2demo.MainApplication;
import com.example.jh.dagger2demo.Poetry;
import com.example.jh.dagger2demo.R;
import com.example.jh.dagger2demo.dagger2.qualifier.PoetryQualifier;
import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 */

public class AActivity extends AppCompatActivity {
    TextView mTextView;


    @Inject
    Gson mGson;

    // 匹配Module中同样注解的方法
    @PoetryQualifier("A")
    @Inject
    Poetry mPoetry;

    // 匹配Module中同样注解的方法
    @PoetryQualifier("B")
    @Inject
    Poetry mPoetryB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        MainApplication.getInstance()
                .getAComponent()
                .inject(this);

        mTextView = (TextView) findViewById(R.id.text);
        String text = mPoetry.getPoems()+",mPoetryA:"+mPoetry+
                mPoetryB.getPoems()+",mPoetryB:"+mPoetryB+
                (mGson == null ? "Gson没被注入" : "Gson已经被注入");
        mTextView.setText(text);
    }
}

