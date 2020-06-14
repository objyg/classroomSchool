package com.example.demo.controller;


import org.springframework.util.DigestUtils;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//调用接口
@CrossOrigin
@RestController
@RequestMapping("/StudentController")
public class StudentController {

    @Autowired
    StudentService studentService;

    //    查询全部学生信息
    @GetMapping("/getAllStudent")
    public List<Student> selectAllStudent(){
        return studentService.selectAllStudent();
    }

//    学生登陆验证
    @PostMapping("/studentLogin")
    public List<Student> studentLogin(@RequestBody String[] condition){
        String md5PassWord = DigestUtils.md5DigestAsHex(condition[1].getBytes());
        List<Student> studentList=studentService.studentLogin(condition[1],md5PassWord);
        if(studentList.size()>0){
            return studentList;
        }
        else {
            return null;
        }
    }

//    根据课程查找学生
    @PostMapping("/selectStudentByCourse")
    public List<Student> selectStudentByCourse(@RequestBody int courseId){
        return studentService.selectStudentByCourse(courseId);
    }
}
