package com.freedy.behaviorPattern.state.demo2;

/**
 * @author Freedy
 * @date 2021/6/19 14:06
 */
public class OpeningState extends LiftState{
    //开启当然可以关闭了，我就想测试一下电梯门开关功能
    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }

    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.CLOSING_STATE);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.context.getLiftState().close();
    }

    @Override
    public void run() { }

    @Override
    public void stop() { }
}
