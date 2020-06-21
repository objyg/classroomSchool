package com.example.demo.entity;

public class WorkStudentFile {
    private Integer workStudentFileId;

    private Integer workId;

    private Integer studentId;

    private String fileName;

    public Integer getWorkStudentFileId() {
        return workStudentFileId;
    }

    public void setWorkStudentFileId(Integer workStudentFileId) {
        this.workStudentFileId = workStudentFileId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }
}