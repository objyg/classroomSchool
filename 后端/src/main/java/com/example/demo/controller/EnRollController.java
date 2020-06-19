package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.loginResult.Result;
import com.example.demo.loginResult.VerifyCodeUtils;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

//调用接口
@CrossOrigin
@RestController
@RequestMapping("/EnRollController")
public class EnRollController {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;



    String verifyCode;


//    生成验证码图片
    @GetMapping("/enTerEnRoll")
    public void yzm(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 生成随机字串
         verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        // 存入会话session
        HttpSession session = request.getSession(true);
        // 删除以前的
        session.removeAttribute("verCode");
        session.removeAttribute("codeTime");
        session.setAttribute("verCode", verifyCode.toLowerCase());		//生成session
        session.setAttribute("codeTime", LocalDateTime.now());
        // 生成图片
        int w = 100, h = 30;
        OutputStream out = response.getOutputStream();
         VerifyCodeUtils.outputImage(w, h, out, verifyCode);

    }

//    注册
    @PostMapping("/enRoll")
    public Result enRollTest(@RequestBody String[] condition){
        System.out.println("1");
       String inputVerCode=condition[5];
        Result result = new Result();
        String types=condition[6];
//    将用户输入的结果与验证码比较
        if(inputVerCode.equals(verifyCode)){
            System.out.println("2");
            if(types.equals("student")) {
                int studentId = Integer.parseInt(condition[0]);
                String name=condition[1];
                String phone=condition[2];
                String school=condition[3];
                String userName=condition[7];
                String passWord=condition[4];
//                判断学号是否存在
                if(studentService.selectStudentByStudentId(studentId)!=null){
                    result.setCode(202);
                    result.setMessage("学号已经存在！");
                    return result;
                }
//                判断用户名是否存在
                else if((studentService.selectStudentByUserName(userName)!=null)||(teacherService.selectTeacherByUserName(userName)!=null)){
                    result.setCode(203);
                    result.setMessage("用户名已经存在！");
                    return result;
                }
                else {
                    Student student = new Student(studentId, name, phone, school, userName, passWord);
                    studentService.insertStudent(student);
                    result.setCode(200);
                    result.setMessage("学生注册成功！");
                    return result;
                }
            }
            else {
                int teacherId=Integer.parseInt(condition[0]);
                String name=condition[1];
                String email=condition[2];
                String school=condition[3];
                String userName="";
                String passWord=condition[4];
                if(teacherService.selectTeacherByTeacherId(teacherId)!=null){
                    result.setCode(202);
                    result.setMessage("职工号已经存在！");
                    return result;
                }
                //                判断用户名是否存在
                else if((studentService.selectStudentByUserName(userName)!=null)||(teacherService.selectTeacherByUserName(userName)!=null)){
                    result.setCode(203);
                    result.setMessage("用户名已经存在！");
                    return result;
                }
                else {
                    Teacher teacher = new Teacher(teacherId, name, email, school, userName, passWord);
                    teacherService.insertTeacher(teacher);
                    result.setCode(200);
                    result.setMessage("教师/助教注册成功！");
                    return result;
                }
            }
        }
        else {
            result.setCode(201);
            result.setMessage("验证码错误!");
            return result;
        }
    }




}
