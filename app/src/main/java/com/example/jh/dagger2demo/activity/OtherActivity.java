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
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 */

public class OtherActivity extends AppCompatActivity {
    //添加@Inject注解，表示这个mPoetry是需要注入的
    @Inject
    Poetry mPoetry;

    @Inject
    Gson mGson;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        MainComponent.getInstance()
                .inject(this);

        initView();

        findViewById(R.id.open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherActivity.this,AActivity.class));
            }
        });
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.tv_poetry);
        String json = mGson.toJson(mPoetry);
        String text = json + ", mPoetry:"+mPoetry;
        mTextView.setText(text);

    }
}