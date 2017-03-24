package com.example.jh.dagger2demo.dagger2.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AScope {
}

