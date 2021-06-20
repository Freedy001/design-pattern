package com.freedy.behaviorPattern.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Freedy
 * @date 2021/6/19 21:23
 */
public class Context {
    private final Map<Variable, Integer> map = new HashMap<>();

    public void assign(Variable variable, Integer value) {
        map.put(variable, value);
    }

    public int getValue(Variable variable) {
        return map.get(variable);
    }

}
