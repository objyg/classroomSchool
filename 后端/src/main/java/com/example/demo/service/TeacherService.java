package com.example.demo.service;


import com.example.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {

//    查询全部教师信息
     List<Teacher> selectAllTeacher();

     //    教师登陆验证
     List<Teacher> teacherLogin(String userName,String passWord);

     //    根据用户名查找教师信息
     Teacher selectTeacherByUserName(String userName);

     //    添加教师信息
     void insertTeacher(Teacher teacher);

     //    根据课程查找教师
     List<Teacher> selectTeacherByCourse(int courseId);

//     根据id查找教师
     Teacher selectTeacherByTeacherId(int teacherId);
}
