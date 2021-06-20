package com.freedy.behaviorPattern.responsibility;


/**
 * @author Freedy
 * @date 2021/6/19 0:01
 */
public abstract class Handler {
    protected final static int NUM_ONE=1;
    protected final static int NUM_THREE=3;
    protected final static int NUM_SEVEN=7;
    private int numStart;
    private int numEnd;
    private Handler nextHandle;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandle(Handler nextHandle) {
        this.nextHandle = nextHandle;
    }

    protected abstract void handleLeave(LeaveRequest request);

    public final void submit(LeaveRequest request){
        if (nextHandle!=null && request.getDays()>numEnd) {
            nextHandle.submit(request);
        }else {
            handleLeave(request);
        }
    }
}