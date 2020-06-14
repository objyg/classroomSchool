package com.example.demo.entity;

public class CourseStudent {
    private Integer id;

    private Integer courseid;

    private Integer studentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public CourseStudent(Integer id, Integer courseid, Integer studentid) {
        this.id = id;
        this.courseid = courseid;
        this.studentid = studentid;
    }

    public CourseStudent(){}
}