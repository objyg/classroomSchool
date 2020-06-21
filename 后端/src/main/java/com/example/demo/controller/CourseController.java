package com.example.demo.controller;


import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import com.example.demo.service.CourseService;
import com.example.demo.service.CourseStudentService;
import com.example.demo.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

//调用接口
@CrossOrigin
@RestController
@RequestMapping("/CourseController")
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    CourseStudentService courseStudentService;
    @Autowired
    CourseTeacherService courseTeacherService;

    //    查询全课程信息
    @GetMapping("/getAllCourse")
    public List<Course> selectAllCourse(){
        return courseService.selectAllCourse();
    }

//    增加课程
    @PostMapping("/insertCourse")
    public void insertCourse(@RequestBody Course course){

//产生随机数用于id
        Random r = new Random();
        int id = r.nextInt(1000000000);

        Course courseA=new Course(id,course.getCoursename(),course.getAddcoursecode(),course.getIntroduction(),course.getTotal(),course.getArchive(),course.getDisplay(),course.getSerialnumber());
        courseService.insertCourse(courseA);
    }

//    显示指定学生的全部课程信息
    @PostMapping("/selectCourseByStudent")
    public List<Course> selectCourseByStudent(@RequestBody int studentId){
        return courseService.selectCourseByStudent(studentId);
    }

    //    显示指定教师的全部课程信息
    @PostMapping("/selectCourseByTeacher")
    public List<Course> selectCourseByTeacher(@RequestBody int teacherId){
        return courseService.selectCourseByTeacher(teacherId);
    }

//    教师归档课程全部（学生加老师）
@PostMapping("/updateAllArchive")
public void updateAllArchive(@RequestBody int courseId){
//        课程归档
    courseService.updateAllArchive(courseId);
//    课程教师归档
    courseTeacherService.updateAllArchive(courseId);
//    课程学生归档
    courseStudentService.updateAllArchive(courseId);
}

}
