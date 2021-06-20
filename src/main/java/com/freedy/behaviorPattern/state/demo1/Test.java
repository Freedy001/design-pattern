package com.freedy.behaviorPattern.state.demo1;

/**
 * @author Freedy
 * @date 2021/6/19 13:55
 */
public class Test {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(ILift.RUNNING_STATE);
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
