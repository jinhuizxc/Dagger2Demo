# Dagger2Demo
dagger2
# 步骤如下：
# 1.// 配置android-apt
classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
# 2.// 在Module下的build.gradle添加以下内容:
apply plugin: 'com.neenbedankt.android-apt'
# 3. compile 'com.google.dagger:dagger:2.10'
apt 'com.google.dagger:dagger-compiler:2.10'
provided 'org.glassfish:javax.annotation:10.0-b28'
compile 'com.google.code.gson:gson:2.8.0'
