package com.freedy.behaviorPattern.state.demo2;

/**
 * @author Freedy
 * @date 2021/6/19 14:19
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        OpeningState state = new OpeningState();
        context.setLiftState(state);
        context.open();
        context.run();
        context.close();
        context.stop();
    }
}
