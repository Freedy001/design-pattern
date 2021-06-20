package com.freedy.customSpring.beans.factory.support;

import com.freedy.customSpring.beans.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册表接口的子实现类
 * @author Freedy
 * @date 2021/6/19 23:23
 */
public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry{
    private final Map<String,BeanDefinition> beanDefinitionMap=new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    @Override
    public void removeBeanDefinition(String beanName) throws Exception {
        beanDefinitionMap.remove(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws Exception {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(String[]::new);
    }
}
