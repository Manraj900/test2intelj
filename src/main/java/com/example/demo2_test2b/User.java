package com.example.demo2_test2b;

public class User {
    private int grade_id;
    private String student_name;

    private String subject;

    private String score;

    public User(int grade_id, String student_name, String subject, String score) {
        this.grade_id = grade_id;
        this.student_name = student_name;
        this.subject = subject;
        this.score = score;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
