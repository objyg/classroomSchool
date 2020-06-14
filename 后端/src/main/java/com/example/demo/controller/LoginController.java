package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.loginResult.Result;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//调用接口
@CrossOrigin
@RestController
@RequestMapping("/LoginController")
public class LoginController {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;



//    登陆验证
    @PostMapping("/Login")
    public Result Login(@RequestBody String[] condition){
        String userName=condition[0];
        String passWord=condition[1];
        String types=condition[2];
        Result result=new Result();
        String md5PassWord = DigestUtils.md5DigestAsHex(passWord.getBytes());
//        判断是学生登陆还是老师登陆
        if(types.equals("student")) {
            List<Student> studentList=studentService.studentLogin(userName,md5PassWord);
            if (studentList.size() > 0) {
                result.setCode(200);
                result.setStudent(studentList.get(0));
                result.setMessage("登陆成功！");
                return result;
            } else if (studentService.selectStudentByUserName(userName).size()>0){
                result.setCode(201);
                result.setMessage("密码错误！");
                return result;
            }
            else {
                result.setCode(202);
                result.setMessage("用户名错误！");
                return result;
            }
        }
        else {
            List<Teacher> teacherList=teacherService.teacherLogin(userName,md5PassWord);
            if (teacherList.size() > 0) {
                result.setCode(200);
                result.setTeacher(teacherList.get(0));
                result.setMessage("登陆成功！");
                return result;
            } else if (teacherService.selectTeacherByUserName(userName).size()>0){
                result.setCode(201);
                result.setMessage("密码错误！");
                return result;
            }
            else {
                result.setCode(202);
                result.setMessage("用户名错误！");
                return result;
            }
        }
    }


}
