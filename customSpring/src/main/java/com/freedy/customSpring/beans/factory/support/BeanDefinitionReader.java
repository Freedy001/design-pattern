package com.freedy.customSpring.beans.factory.support;

/**
 * 用来解析配置文件的
 * @author Freedy
 * @date 2021/6/19 23:34
 */
public interface BeanDefinitionReader {
    //获取注册表对象
    BeanDefinitionRegistry getRegistry();
    //加载配置文件并在注册表中进行注册
    void loadBeanDefinitions(String configLocation) throws Exception;
}
