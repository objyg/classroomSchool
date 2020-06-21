package com.example.demo.entity;

public class CourseFile {
    private Integer courseFileId;

    private Integer courseId;

    private String fileName;

    public Integer getCourseFileId() {
        return courseFileId;
    }

    public void setCourseFileId(Integer courseFileId) {
        this.courseFileId = courseFileId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }
}