package com.example.demo.service;


import com.example.demo.entity.CourseTeacher;

import java.util.List;

public interface CourseTeacherService {

     //    查询全部教师授课信息
     List<CourseTeacher> selectAllCourseTeacher();

     //    教师加入课程
     void insertCourseTeacher(CourseTeacher courseTeacher);

     //    删除教师加入的课程
     void deleteCourseTeacher(int id);
}
