package com.example.demo.service;


import com.example.demo.entity.CourseStudent;

import java.util.List;

public interface CourseStudentService {

//     查询全部学生选课信息
     List<CourseStudent> selectAllCourseStudent();

     //    增加学生选课信息
     void insertCourseStudent(CourseStudent courseStudent);

     //    删除学生的选课
     void deleteCourseSrudent(int id);
}
