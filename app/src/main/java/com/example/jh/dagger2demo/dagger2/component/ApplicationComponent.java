package com.example.jh.dagger2demo.dagger2.component;

import com.example.jh.dagger2demo.dagger2.modules.AModule;
import com.example.jh.dagger2demo.dagger2.modules.ApplicationModule;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 *
 * 我们在一个项目之中不可能只使用一个Component连接器来注入对象完成注入工作，
 * 一般除了一个全局的ApplicationComponent之外，还有一些作用域在Activity/Fragment的Component，
 * Component之间存在依赖关系与从属关系。如果我们已经创建好了一个全局的ApplicationComponent，
 * 然后其它的Component刚好需要ApplicationComponent里面的一个全局属性，
 * 想要与ApplicationComponent共享同一个实例，这时就需要用到依赖关系了。
 *
 * 依赖方式
 * 一个Component可以依赖一个或多个Component，并拿到被依赖Component暴露出来的实例，
 * Component的dependencies属性就是确定依赖关系的实现。
 * 这里的有点像数学里面的交集方式，被依赖的Component主动暴露对象给二者共享，
 * 如我们在ApplicationModule提供了一个全局的Gson对象，我们想要提供给其他Component时，
 * 要在ApplicationComponent显式的提供一个接口:
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Gson getGson();// 暴露Gson对象接口
    //AComponent plus();
    AComponent plus(AModule module);//添加声明
}