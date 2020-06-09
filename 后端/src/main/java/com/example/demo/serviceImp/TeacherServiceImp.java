package com.example.demo.serviceImp;


import com.example.demo.dao.TeacherMapper;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//实现类
@Service
public class TeacherServiceImp implements TeacherService {


    @Autowired(required = false)
    TeacherMapper teacherMapper;

//    查询全部教师信息
@Override
    public List<Teacher> selectAllTeacher(){
        return teacherMapper.selectAllTeacher();
    }

    @Override
    public List<Teacher> teacherLogin(String userName, String passWord) {
       return teacherMapper.teacherLogin(userName,passWord);
    }

    @Override
    public List<Teacher> selectTeacherByUserName(String userName) {
        return teacherMapper.selectTeacherByUserName(userName);
    }
}
