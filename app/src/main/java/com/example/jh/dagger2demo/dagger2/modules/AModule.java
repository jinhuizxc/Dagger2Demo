package com.example.jh.dagger2demo.dagger2.modules;

import com.example.jh.dagger2demo.Poetry;
import com.example.jh.dagger2demo.dagger2.qualifier.PoetryQualifier;
import com.example.jh.dagger2demo.dagger2.scope.AScope;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 */

@Module
public class AModule {

    @PoetryQualifier("A")
    @AScope
    @Provides
    public Poetry getPoetry(){
        return new Poetry("万物美好");
    }

    @PoetryQualifier("B")
    @AScope
    @Provides
    public Poetry getOtherPoetry(){
        return new Poetry("我在中间");
    }
}

