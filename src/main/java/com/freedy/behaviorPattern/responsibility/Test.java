package com.freedy.behaviorPattern.responsibility;

/**
 * @author Freedy
 * @date 2021/6/19 0:14
 */
public class Test {
    public static void main(String[] args) {
        LeaveRequest request = new LeaveRequest("小明", 10, "haha");
        GroupLeader leader1 = new GroupLeader();
        ManagerLeader leader2 = new ManagerLeader();
        GeneralLeader leader3 = new GeneralLeader();
        leader1.setNextHandle(leader2);
        leader2.setNextHandle(leader3);

        leader1.submit(request);
    }
}
