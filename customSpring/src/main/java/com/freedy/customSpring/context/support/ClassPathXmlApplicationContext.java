package com.freedy.customSpring.context.support;

import com.freedy.customSpring.beans.BeanDefinition;
import com.freedy.customSpring.beans.PropertyValue;
import com.freedy.customSpring.beans.factory.xm.XMLBeanDefinitionReader;

import java.lang.reflect.Field;

/**
 * IOC容器的具体子实现类
 *  用于加载类路径下的配置文件
 * @author Freedy
 * @date 2021/6/20 0:22
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    public ClassPathXmlApplicationContext(String configLocation) {
        super.configLocation=configLocation;
        beanDefinitionReader=new XMLBeanDefinitionReader();
        try {
            refresh();
        } catch (Exception ignore) { }
    }

    /**
     * 根据bean对象的名称获取bean对象
     */
    @Override
    public Object getBean(String name) throws Exception {
        Object obj = singletonObjects.get(name);
        if (obj!=null) return obj;
        BeanDefinition definition = beanDefinitionReader.getRegistry().getBeanDefinition(name);
        Class<?> beanClazz = Class.forName(definition.getClassName());
        Object instance = beanClazz
                .getConstructor().newInstance();
        singletonObjects.put(name,instance);
        //依赖注入
        for (PropertyValue property : definition.getPropertyValues()) {
            String propertyName = property.getName();
            String value = property.getValue();
            String ref = property.getRef();
            if (ref!=null&&!"".equals(ref)){
                Object dependencyBean = getBean(ref);
                Field field = beanClazz.getDeclaredField(propertyName);
                field.setAccessible(true);
                field.set(instance, dependencyBean);
            }else if (value!=null&&!"".equals(value)){
                Field field = beanClazz.getDeclaredField(propertyName);
                field.setAccessible(true);
                field.set(instance, value);
            }

        }
        return instance;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(name);
        if (bean==null) return null;
        return clazz.cast(bean);
    }
}
