package com.freedy.behaviorPattern.iterator;

/**
 * @author Freedy
 * @date 2021/6/19 18:01
 */
public class Test {
    public static void main(String[] args) {
        StudentAggregate aggregate = new StudentAggregateImpl();
        aggregate.addStudent(new Student("张三","12"));
        aggregate.addStudent(new Student("李斯特","20"));
        aggregate.addStudent(new Student("傅撒","10"));
        StudentIterator iterator = aggregate.getStudentIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
