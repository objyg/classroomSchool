package com.example.demo.controller;


import com.example.demo.entity.CourseTeacher;
import com.example.demo.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

//调用接口
@CrossOrigin
@RestController
@RequestMapping("/CourseTeacherController")
public class CourseTeacherController {

    @Autowired
    CourseTeacherService courseTeacherService;

    //    查询全部教师信息
    @GetMapping("/getAllCourseTeacher")
    public List<CourseTeacher> selectAllCourseTeacher(){
        return courseTeacherService.selectAllCourseTeacher();
    }

    //    增加教师加入课程信息
    @PostMapping("/insertCourseTeacher")
    public void insertCourseTeacher(@RequestBody CourseTeacher courseTeacher){

//产生随机数用于id
        Random r = new Random();
        int id = r.nextInt(1000000000);

        CourseTeacher courseTeacherA=new CourseTeacher(id,courseTeacher.getCourseid(),courseTeacher.getTeacherid(),courseTeacher.getRole());
        courseTeacherService.insertCourseTeacher(courseTeacherA);
    }

//    删除教师加入的课程信息
    @PostMapping("/deleteCourseTeacher")
    public void deleteCourseTeacher(@RequestBody int id){
        courseTeacherService.deleteCourseTeacher(id);
    }
}
