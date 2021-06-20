package com.freedy.customSpring.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用来存储和管理多个propertyValue对象
 * @author Freedy
 * @date 2021/6/19 23:04
 */
public class MutablePropertyValues implements Iterable<PropertyValue> {
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList==null) {
            this.propertyValueList = new ArrayList<>();
            return;
        }
        this.propertyValueList = propertyValueList;
    }

    public PropertyValue[] getPropertyValueArray(){
        return propertyValueList.toArray(PropertyValue[]::new);
    }

    /**
     * 根据name获取PropertyValue对象
     */
    public PropertyValue getPropertyValue(String name){
        for (PropertyValue value : propertyValueList) {
            if (value.getName().equals(name)) return value;
        }
        return null;
    }

    public boolean isEmpty(){
        return propertyValueList.isEmpty();
    }

    public MutablePropertyValues addPropertyValue(PropertyValue value){
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue propertyValue = propertyValueList.get(i);
            if (value.getName().equals(propertyValue.getName())){
                propertyValueList.set(i,value);
                return this;
            }
        }
        propertyValueList.add(value);
        return this;
    }

    public boolean contains(String name){
        return getPropertyValue(name)!=null;
    }

    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
}
