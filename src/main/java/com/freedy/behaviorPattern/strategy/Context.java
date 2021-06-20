package com.freedy.behaviorPattern.strategy;

/**
 * @author Freedy
 * @date 2021/6/18 22:38
 */
public class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sailsManShow(){
        strategy.show();
    }

}
