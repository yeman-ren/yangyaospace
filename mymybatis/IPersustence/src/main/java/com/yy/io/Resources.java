package com.yy.io;

import java.io.InputStream;

/**
 * 读取配置文件，返回流
 * @since 2021/5/6
 */
public class Resources {

    /**
     * 根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
     * @param path
     */
    public static InputStream getResourceAsSteam(String path) {
        //获取类加载器
        ClassLoader classLoader = Resources.class.getClassLoader();
        //读取配置文件为InputStream流
        return classLoader.getResourceAsStream(path);
    }
}
