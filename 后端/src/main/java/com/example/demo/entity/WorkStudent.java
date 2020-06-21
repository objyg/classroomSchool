package com.example.demo.entity;

import java.util.Date;

public class WorkStudent {
    private Integer workid;

    private Integer studentid;

    private String status;

    private Date submittime;

    private String text;

    private String message;

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public WorkStudent(Integer workid, Integer studentid, String status, Date submittime, String text, String message, int score) {
        this.workid = workid;
        this.studentid = studentid;
        this.status = status;
        this.submittime = submittime;
        this.text = text;
        this.message = message;
        this.score = score;
    }

    public WorkStudent(){}
}