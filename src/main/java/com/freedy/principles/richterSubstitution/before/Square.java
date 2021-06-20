package com.freedy.principles.richterSubstitution.before;

/**
 * @author Freedy
 * @date 2021/6/6 23:28
 */
public class Square extends Rectangle{
    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setLength(width);
        super.setWidth(width);
    }
}
