package com.example.demo.entity;

import java.util.Date;

public class Work {
    private Integer workid;

    private Integer courseid;

    private String type;

    private Date releasedate;

    private Date deadline;

    private String title;

    private Integer revised;

    private Integer unreviewed;

    private Integer submittednum;

    private Integer unpaidnum;

    private Integer marks;

    private String content;

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getRevised() {
        return revised;
    }

    public void setRevised(Integer revised) {
        this.revised = revised;
    }

    public Integer getUnreviewed() {
        return unreviewed;
    }

    public void setUnreviewed(Integer unreviewed) {
        this.unreviewed = unreviewed;
    }

    public Integer getSubmittednum() {
        return submittednum;
    }

    public void setSubmittednum(Integer submittednum) {
        this.submittednum = submittednum;
    }

    public Integer getUnpaidnum() {
        return unpaidnum;
    }

    public void setUnpaidnum(Integer unpaidnum) {
        this.unpaidnum = unpaidnum;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Work(Integer workid, Integer courseid, String type, Date releasedate, Date deadline, String title, String content ,Integer revised, Integer unreviewed, Integer submittednum, Integer unpaidnum, Integer marks) {
        this.workid = workid;
        this.courseid = courseid;
        this.type = type;
        this.releasedate = releasedate;
        this.deadline = deadline;
        this.title = title;
        this.revised = revised;
        this.unreviewed = unreviewed;
        this.submittednum = submittednum;
        this.unpaidnum = unpaidnum;
        this.marks = marks;
        this.content = content;
    }

    public Work(){}
}