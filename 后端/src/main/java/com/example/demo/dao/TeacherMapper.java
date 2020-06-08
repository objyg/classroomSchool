package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TeacherMapper {

//    查询全部教师信息
    List<Teacher> selectAllTeacher();
}