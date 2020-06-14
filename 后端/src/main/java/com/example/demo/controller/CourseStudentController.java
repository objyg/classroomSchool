package com.example.demo.controller;


import com.example.demo.entity.CourseStudent;
import com.example.demo.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

//调用接口
@CrossOrigin
@RestController
@RequestMapping("/CourseStudentController")
public class CourseStudentController {

    @Autowired
    CourseStudentService courseStudentService;

    //    查询全部学生选课信息
    @GetMapping("/getAllCourseStudent")
    public List<CourseStudent> selectAllCourseStudent(){
        return courseStudentService.selectAllCourseStudent();
    }

//    增加学生选课信息
    @PostMapping("/insertCourseStudent")
    public void insertCourseStudent(@RequestBody CourseStudent courseStudent){

//产生随机数用于id
        Random r = new Random();
        int id = r.nextInt(1000000000);

        CourseStudent courseStudentA=new CourseStudent(id,courseStudent.getCourseid(),courseStudent.getStudentid());
        courseStudentService.insertCourseStudent(courseStudentA);
    }

//    删除学生的选课
    @PostMapping("/deleteCourseStudent")
    public void deleteCourseStudent(@RequestBody int id){
        courseStudentService.deleteCourseSrudent(id);
    }

}
