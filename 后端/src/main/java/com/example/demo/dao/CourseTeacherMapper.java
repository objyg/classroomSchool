package com.example.demo.dao;

import com.example.demo.entity.CourseTeacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseTeacherMapper {

//    查询全部教师授课信息
    List<CourseTeacher> selectAllCourseTeacher();

//    教师加入课程
    void insertCourseTeacher(CourseTeacher courseTeacher);

//    删除教师加入的课程
    void deleteCourseTeacher(int id);

//    教师归档自己的课程
    void updateOneArchive(int courseId,int teacherId);

    //    归档全部
    void updateAllArchive(int courseId);

}