package com.example.demo.dao;

import com.example.demo.entity.CourseStudent;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseStudentMapper {

//    查询全部学生选课信息
    List<CourseStudent> selectAllCourseStudent();

//    增加学生选课信息
    void insertCourseStudent(CourseStudent courseStudent);

//    删除学生的选课
    void deleteCourseSrudent(int id);

//    根据课程号查找学生选课
    List<CourseStudent> selectCourseStudentByCourseId(int courseId);

//    学生归档自己课程
    void updateOneArchive(int courseId,int studentId);

//    归档全部
    void updateAllArchive(int courseId);


}