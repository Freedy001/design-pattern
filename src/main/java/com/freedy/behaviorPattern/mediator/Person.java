package com.freedy.behaviorPattern.mediator;

import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * @author Freedy
 * @date 2021/6/19 17:19
 */
@AllArgsConstructor
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public abstract void contact(String msg);

    public abstract void getMessage(String message);
}
