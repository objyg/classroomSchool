package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

//    查询全部学生信息
     List<Student> selectAllStudent();


//     学生登陆验证
     List<Student> studentLogin(String userName,String passWord);
}
