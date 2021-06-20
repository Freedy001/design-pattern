package com.freedy.behaviorPattern.responsibility;

/**
 * @author Freedy
 * @date 2021/6/19 0:08
 */
public class GroupLeader extends Handler{
    public GroupLeader() {
        super(0, NUM_ONE);
    }

    @Override
    protected void handleLeave(LeaveRequest request) {
        System.out.println(request.getName()+"请假"+request.getDays()+"天,原因"+request.getContent());
        System.out.println("小组领导批准");
    }
}
