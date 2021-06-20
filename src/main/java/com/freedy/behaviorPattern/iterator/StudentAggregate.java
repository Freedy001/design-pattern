package com.freedy.behaviorPattern.iterator;

/**
 * @author Freedy
 * @date 2021/6/19 17:58
 */
public interface StudentAggregate {
    void addStudent(Student stu);
    void removeStudent(Student stu);
    StudentIterator getStudentIterator();
}
