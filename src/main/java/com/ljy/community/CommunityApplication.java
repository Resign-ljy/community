package com.ljy.community;
// 这里也不会报错了如果是要使用lombok的话还要安装一个插件，安装插件要翻墙，为了下载jar包不报错就等下面的build完成了之后再去开那个小飞机去下载插件

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 现在要删除一些初始化没有用的文件了
@SpringBootApplication
public class CommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}//右下角那个地址换成了阿里的说明换源成功了
//现在那些库都在导入进来
