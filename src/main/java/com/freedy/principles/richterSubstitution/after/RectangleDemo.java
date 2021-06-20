package com.freedy.principles.richterSubstitution.after;


/**
 * @author Freedy
 * @date 2021/6/7 23:09
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
        square.setSide(20);
        //--->resize(square);
        printLengthAndWidth(rectangle);
    }

    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() <=rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth()+1);
        }
    }

    public static void printLengthAndWidth(Quadrilateral quadrilateral){
        System.out.println("length ---> "+quadrilateral.getLength());
        System.out.println("width  ---> "+quadrilateral.getWidth());
    }

}
