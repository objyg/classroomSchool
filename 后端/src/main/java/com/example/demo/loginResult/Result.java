package com.example.demo.loginResult;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;

public class Result {
    private Student student;
    private Teacher teacher;
//    状态码
    private int code;
//    登陆信息
    private String message;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
