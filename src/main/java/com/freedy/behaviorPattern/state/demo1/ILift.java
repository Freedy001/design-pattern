package com.freedy.behaviorPattern.state.demo1;

/**
 * @author Freedy
 * @date 2021/6/19 13:44
 */
public interface ILift {
    int OPENING_STATE = 1;
    int CLOSE_STATE=2;
    int RUNNING_STATE=3;
    int STOPPING_STATE=4;

    void setState(int state);
    void open();
    void close();
    void run();
    void stop();
}
