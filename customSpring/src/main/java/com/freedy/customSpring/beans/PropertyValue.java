package com.freedy.customSpring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用来封装bean标签下的property标签的熟悉
 * @author Freedy
 * @date 2021/6/19 23:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValue {
    private String name;
    private String ref;
    private String value;
}
