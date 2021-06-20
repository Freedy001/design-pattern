package com.freedy.customSpring.beans;

import lombok.Builder;
import lombok.Data;

/**
 * 用来封装bean标签的数据
 * @author Freedy
 * @date 2021/6/19 23:18
 */
@Builder
@Data
public class BeanDefinition {
    private String id;
    private String className;
    private MutablePropertyValues propertyValues;
}
