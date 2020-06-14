package com.example.demo.entity;

public class Student {
    private Integer studentid;

    private String name;

    private String phone;

    private String school;

    private String username;

    private String password;

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Student(Integer studentid, String name, String phone, String school, String username, String password) {
        this.studentid = studentid;
        this.name = name;
        this.phone = phone;
        this.school = school;
        this.username = username;
        this.password = password;
    }

    public Student(){}
}