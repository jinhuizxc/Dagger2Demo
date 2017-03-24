package com.example.jh.dagger2demo.dagger2.component;

import com.example.jh.dagger2demo.activity.AActivity;
import com.example.jh.dagger2demo.dagger2.modules.AModule;
import com.example.jh.dagger2demo.dagger2.scope.AScope;

import dagger.Subcomponent;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 */

@AScope
@Subcomponent(modules = AModule.class)
public interface AComponent {
    void inject(AActivity activity);
}
