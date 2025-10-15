package org.example;

public class Student implements Comparable<Student>{

    private String name;
    private int age;
    private double height;

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }


}
