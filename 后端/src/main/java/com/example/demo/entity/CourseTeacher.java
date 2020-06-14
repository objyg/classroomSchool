package com.example.demo.entity;

public class CourseTeacher {
    private Integer id;

    private Integer courseid;

    private Integer teacherid;

    private String role;

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

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public CourseTeacher(Integer id, Integer courseid, Integer teacherid, String role) {
        this.id = id;
        this.courseid = courseid;
        this.teacherid = teacherid;
        this.role = role;
    }

    public CourseTeacher(){}
}