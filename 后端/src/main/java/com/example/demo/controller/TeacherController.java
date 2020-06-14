package com.example.demo.controller;


import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//调用接口
@CrossOrigin
@RestController
@RequestMapping("/TeacherController")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //    查询全部教师信息
    @GetMapping("/getAllTeacher")
    public List<Teacher> selectAllTeacher(){
        return teacherService.selectAllTeacher();
    }

    //    根据课程查找学生
    @PostMapping("/selectTeacherByCourse")
    public List<Teacher> selectTeacherByCourse(@RequestBody int courseId){
        return teacherService.selectTeacherByCourse(courseId);
    }
}
