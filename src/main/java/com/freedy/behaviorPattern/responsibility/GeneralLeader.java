package com.freedy.behaviorPattern.responsibility;

/**
 * @author Freedy
 * @date 2021/6/19 0:08
 */
public class GeneralLeader extends Handler{
    public GeneralLeader() {
        super(NUM_THREE, NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest request) {
        System.out.println(request.getName()+"请假"+request.getDays()+"天,原因"+request.getContent());
        System.out.println("总经理批准");
    }
}
