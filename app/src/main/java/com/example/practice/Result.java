package com.example.practice;

public class Result {


    private String name;
    private String subject;
    private String mark;
    private String grade;
    private String age;

    public Result()
    {

    }

    public Result(String name, String subject, String mark, String grade, String age) {
        this.name = name;
        this.subject = subject;
        this.mark = mark;
        this.grade = grade;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
