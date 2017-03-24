package com.example.jh.dagger2demo.dagger2.modules;

import com.example.jh.dagger2demo.Poetry;
import com.example.jh.dagger2demo.dagger2.scope.PoetryScope;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：jinhui on 2017/3/23
 * 邮箱：1004260403@qq.com
 *
 * 这里涉及到一个优先级问题：
 * 在上面这种既在构造函数中用@Inject提供注入来源，也在@Module中用@Privodes注解提供注入来源的，
 * Dagger2是先从@Privodes查找类实例，如果找到了就用@Module提供的方法来创建类实例，
 * 如果没有就从构造函数里用@Inject注解的生成类实例，如果二者都没有，则报错，
 * 简而言之————————>就是@Module的优先级高于@Inject。
 * 另外这里还要说明一点，在providePoetry(String)方法中，
 * String这个参数也是要注入提供的，必须也要有在同一个连接器里面有提供，
 *
 *
 * 在构建类实例的时候，会按照以下顺序执行：
 *从Module中查找类实例创建方法
 * Module中存在创建方法，则看此创建方法有没有参数
 * 如果有参数，这些参数也是由Component提供的，返回步骤1逐一生成参数类实例，最后再生成最终类实例
 * 如果无参数，则直接由这个方法生成最终类实例
 * Module中没有创建方法，则从构造函数里面找那个用@Inject注解的构造函数
 * 如果该构造函数有参数，则也是返回到步骤1逐一生成参数类实例，最后调用该构造函数生成类实例
 * 如果该构造函数无参数，则直接调用该构造函数生成类实例
 * 以上就是一次注入生成类实例的生成步骤。
 */

@Module
public class PoetryModule {

    // 这个方法需要一个String参数，在Dagger2注入中，这些参数也是注入形式的，也就是
    // 要有其他对方提供参数poems的生成，不然会造成编译出错
    @PoetryScope
    @Provides
    public Poetry providePoetry(String poems){
        return new Poetry(poems);
    }

    // 这里提供了一个生成String的方法，在这个Module里生成Poetry实例时，会查找到这里
    // 可以为上面提供String类型的参数
    @Provides
    public String providePoems(){
        return "只有意志坚强的人，才能到达彼岸";
    }
}
