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
}