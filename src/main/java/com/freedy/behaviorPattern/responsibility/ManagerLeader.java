package com.freedy.behaviorPattern.responsibility;

/**
 * @author Freedy
 * @date 2021/6/19 0:08
 */
public class ManagerLeader extends Handler{
    public ManagerLeader() {
        super(NUM_ONE, NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest request) {
        System.out.println(request.getName()+"请假"+request.getDays()+"天,原因"+request.getContent());
        System.out.println("部门经理批准");
    }
}
