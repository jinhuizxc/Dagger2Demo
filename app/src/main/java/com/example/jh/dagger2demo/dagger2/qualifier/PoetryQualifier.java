package com.example.jh.dagger2demo.dagger2.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PoetryQualifier {
    String value() default "";
}

