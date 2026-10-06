package com.example.studentmanagement;

public class Student {

    private int rollNo;
    private String name;
    private String email;
    private String course;
    private int semester;

    public Student() {
    }

    public Student(int rollNo, String name, String email,
                   String course, int semester) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.semester = semester;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}