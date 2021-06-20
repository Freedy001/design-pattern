package com.freedy.structPattern.decorate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Freedy
 * @date 2021/6/17 23:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class FastFoot {
    private float price;
    private String desc;
    public abstract float cost();
}
