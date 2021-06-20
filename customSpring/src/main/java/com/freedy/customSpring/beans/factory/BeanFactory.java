package com.freedy.customSpring.beans.factory;

/**
 * IOC容器父接口
 *
 * @author Freedy
 * @date 2021/6/20 0:06
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}
