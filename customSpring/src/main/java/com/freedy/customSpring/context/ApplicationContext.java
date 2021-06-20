package com.freedy.customSpring.context;

import com.freedy.customSpring.beans.factory.BeanFactory;

/**
 * 非延时加载
 * @author Freedy
 * @date 2021/6/20 0:08
 */
public interface ApplicationContext extends BeanFactory {
    void refresh() throws Exception;
}
