package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TeacherMapper {

//    查询全部教师信息
    List<Teacher> selectAllTeacher();

//    教师登陆验证
    List<Teacher> teacherLogin(String userName,String passWord);

//    根据用户名查找教师信息
    List<Teacher> selectTeacherByUserName(String userName);
}