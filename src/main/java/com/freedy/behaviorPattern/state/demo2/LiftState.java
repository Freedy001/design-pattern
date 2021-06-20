package com.freedy.behaviorPattern.state.demo2;

/**
 * @author Freedy
 * @date 2021/6/19 14:05
 */
public abstract class LiftState {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}
