package com.freedy.behaviorPattern.iterator;

import java.util.List;

/**
 * @author Freedy
 * @date 2021/6/19 17:56
 */
public class StudentIteratorImpl implements StudentIterator{
    private final List<Student> list;
    private int position=0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.size()>position;
    }

    @Override
    public Student next() {
        return list.get(position++);
    }
}
