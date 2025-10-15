package edu.franklin;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String phone;
    private List<Course> coursesTaken;

    public Student() {}

    public Student(int id, String name, String phone, List<Course> coursesTaken) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.coursesTaken = coursesTaken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Course> getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(List<Course> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }
}
