package com.freedy.behaviorPattern.state.demo2;

import lombok.Data;
import lombok.Getter;

/**
 * @author Freedy
 * @date 2021/6/19 14:05
 */
@Getter
public class Context{
    public final static OpeningState OPENING_STATE = new OpeningState();
    public final static RunningState RUNNING_STATE = new RunningState();
    public final static StoppingState STOPPING_STATE = new StoppingState();
    public final static ClosingState CLOSING_STATE = new ClosingState();

    private LiftState liftState;

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open() {
        liftState.open();
    }

    public void close() {
        liftState.close();
    }

    public void run() {
        liftState.run();
    }

    public void stop() {
        liftState.stop();
    }

}