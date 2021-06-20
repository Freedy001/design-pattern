package com.freedy.customSpring.beans.factory.xm;

import com.freedy.customSpring.beans.BeanDefinition;
import com.freedy.customSpring.beans.MutablePropertyValues;
import com.freedy.customSpring.beans.PropertyValue;
import com.freedy.customSpring.beans.factory.support.BeanDefinitionReader;
import com.freedy.customSpring.beans.factory.support.BeanDefinitionRegistry;
import com.freedy.customSpring.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freedy
 * @date 2021/6/19 23:35
 */
public class XMLBeanDefinitionReader implements BeanDefinitionReader {
    private final SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        for (Element element : SAXReader.createDefault()
                .read(XMLBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation))
                .getRootElement().elements("bean")
        ) {
            String id = element.attributeValue("id");
            List<PropertyValue> values = new ArrayList<>();
            element.elements("property").forEach(property -> values.add(new PropertyValue(
                    property.attributeValue("name"),
                    property.attributeValue("ref"),
                    property.attributeValue("value")
            )));
            BeanDefinition definition = BeanDefinition.builder().id(id)
                    .className(element.attributeValue("class"))
                    .propertyValues(new MutablePropertyValues(values))
                    .build();
            registry.registerBeanDefinition(id, definition);
        }
    }
}
