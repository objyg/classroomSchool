package com.example.demo.entity;

public class Course {
    private Integer courseid;

    private String coursename;

    private String addcoursecode;

    private String introduction;

    private Integer total;

    private Integer archive;

    private Integer display;

    private Integer serialnumber;

    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getAddcoursecode() {
        return addcoursecode;
    }

    public void setAddcoursecode(String addcoursecode) {
        this.addcoursecode = addcoursecode == null ? null : addcoursecode.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getArchive() {
        return archive;
    }

    public void setArchive(Integer archive) {
        this.archive = archive;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(Integer serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Course(Integer courseid, String coursename, String addcoursecode, String introduction, Integer total, Integer archive, Integer display, Integer serialnumber) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.addcoursecode = addcoursecode;
        this.introduction = introduction;
        this.total = total;
        this.archive = archive;
        this.display = display;
        this.serialnumber = serialnumber;
    }

    public Course(){}
}