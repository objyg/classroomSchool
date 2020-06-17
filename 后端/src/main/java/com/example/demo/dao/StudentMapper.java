package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
//    查询全部学生信息
    List<Student> selectAllStudent();


//    学生登陆验证
    List<Student> studentLogin(String userName,String passWord);

//    根据用户名查找学生信息
    Student selectStudentByUserName(String userName);

//    添加学生信息
    void insertStudent(Student student);

//    根据课程查找学生
    List<Student> selectStudentByCourse(int courseId);

//    根据学号查找学生
    Student selectStudentByStudentId(int studentId);
}