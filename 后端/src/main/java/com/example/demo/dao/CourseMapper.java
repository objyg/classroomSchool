package com.example.demo.dao;

import com.example.demo.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

//    查询全部课程信息
    List<Course> selectAllCourse();

    //    增加课程
    void insertCourse(Course course);

//    显示指定学生的所有加入的课程
        List<Course> selectCourseByStudent(int studentId);

//        显示指定教师所有加入的课程
    List<Course> selectCourseByTeacher(int teacherId);
}