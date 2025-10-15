package edu.franklin;

public class Course {
    private String prefix;
    private int number;
    private String semester;
    private String grade;

    public Course() {}

    public Course(String prefix, int number, String semester, String grade) {
        this.prefix = prefix;
        this.number = number;
        this.semester = semester;
        this.grade = grade;
    }

    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
