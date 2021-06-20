package com.freedy.principles.richterSubstitution.before;

/**
 * @author Freedy
 * @date 2021/6/6 23:30
 */
public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setLength(20);
        resize(rectangle);
        printLengthAndWidth(rectangle);
        System.out.println("============================");
        Square square = new Square();
        square.setWidth(20);
        resize(square);
        printLengthAndWidth(rectangle);
    }

    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() <=rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth()+1);
        }
    }

    public static void printLengthAndWidth(Rectangle rectangle){
        System.out.println("length ---> "+rectangle.getLength());
        System.out.println("width  ---> "+rectangle.getWidth());
    }


}
