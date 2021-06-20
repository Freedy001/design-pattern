package com.freedy.behaviorPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freedy
 * @date 2021/6/18 23:33
 */
public class Waiter {
    private final List<Command> commands=new ArrayList<>();
    public void setCommand(Command cmd){
        commands.add(cmd);
    }
    public void orderUp(){
        System.out.println("新订单来了！");
        for (Command command : commands) {
            command.execute();
        }
    }
}
