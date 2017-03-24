package com.example.jh.dagger2demo;

import javax.inject.Inject;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 */

public class Poetry {

    private String mPoems;

    // 用Inject标记构造函数,表示用它来注入到目标对象中去
    @Inject
    public Poetry() {
        mPoems = "生活就像海洋";
    }

    // 有参构造
    public Poetry(String poems){
        mPoems = poems;
    }

    public String getPoems() {
        return mPoems;
    }
}
