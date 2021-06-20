package com.freedy.customSpring.context.support;

import com.freedy.customSpring.beans.factory.support.BeanDefinitionReader;
import com.freedy.customSpring.beans.factory.support.BeanDefinitionRegistry;
import com.freedy.customSpring.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;


/**
 * ApplicationContext接口子实现类
 * @author Freedy
 * @date 2021/6/20 0:11
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected BeanDefinitionReader beanDefinitionReader;
    protected Map<String, Object> singletonObjects=new HashMap<>();
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        finishBeanInitialization();
    }

    private void finishBeanInitialization(){
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        for (String beanName : registry.getBeanDefinitionNames()) {
            try {
                getBean(beanName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
