package com.freedy.behaviorPattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freedy
 * @date 2021/6/19 17:59
 */
public class StudentAggregateImpl implements StudentAggregate{
    private final List<Student> list=new ArrayList<>();
    @Override
    public void addStudent(Student stu) {
        list.add(stu);
    }

    @Override
    public void removeStudent(Student stu) {
        list.remove(stu);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}
