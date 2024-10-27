package org.example;

public class Student {
    int id;
    String dept;

    public Student(int id, String dept) {
        this.id = id;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", dept='" + dept + '\'' +
                '}';
    }
}
