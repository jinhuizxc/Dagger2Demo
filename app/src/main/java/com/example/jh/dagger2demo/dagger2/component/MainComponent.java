package com.example.jh.dagger2demo.dagger2.component;

import com.example.jh.dagger2demo.MainApplication;
import com.example.jh.dagger2demo.activity.MainActivity;
import com.example.jh.dagger2demo.activity.OtherActivity;
import com.example.jh.dagger2demo.dagger2.modules.MainModule;
import com.example.jh.dagger2demo.dagger2.modules.PoetryModule;
import com.example.jh.dagger2demo.dagger2.scope.PoetryScope;

import dagger.Component;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 * 用@Component表示这个接口是一个连接器，能用@Component注解的只能是interface或者抽象类
 * 这里表示Component会从MainModule类中拿那些用@Provides注解的方法来生成需要注入的实例
 *
 * @dependencies属性
 * 一个Component可以依赖一个或多个Component，并拿到被依赖Component暴露出来的实例，
 * Component的dependencies属性就是确定依赖关系的实现。
 *
 * 这样就达到了MainComponent依赖ApplicationComponent。并且这里需要注意的是，
 * MainComponent的作用域不能和ApplicationComponent的作用域一样，
 * 否则会报错，一般来讲，我们应该对每个Component都定义不同的作用域。
 *
 */
@PoetryScope
@Component(dependencies = ApplicationComponent.class, modules = PoetryModule.class)
public abstract class MainComponent {
    /**
     * 需要用到这个连接器的对象，就是这个对象里面有需要注入的属性
     * （被标记为@Inject的属性）
     * 这里inject表示注入的意思，这个方法名可以随意更改，但建议就
     * 用inject即可。
     */
    public abstract void inject(MainActivity activity);
    public abstract void inject(OtherActivity activity);

    public static MainComponent sComponent;
    public static MainComponent getInstance(){
        if (sComponent == null){
            sComponent = DaggerMainComponent.builder()
                    .applicationComponent(MainApplication
                    .getInstance().getApplicationComponent())
                    .build();
        }
        return sComponent;
    }

}
