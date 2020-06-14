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


//
//    int numberA ;
//    int numberB ;
//    int rule ;
//
////    返回验证码
//@GetMapping("/enTerEnRoll")
//    public int[] enTerEnRoll(){
//    //        生成随机数
//    Random r = new Random();
//     numberA = r.nextInt(10);
//     numberB = r.nextInt(10);
//     rule = r.nextInt(4);
//
//    int [] enroll=new int[3];
//    enroll[0]=numberA;
//    enroll[1]=numberB;
//    enroll[2]=rule;
//    return enroll;
//    }
//
////    注册
//    @PostMapping("/enRoll")
//    public String enRoll(){
//    double result=0;
//    double answer;
//
//    String types="student";
//
////    计算答案
//    switch (rule){
//        case 0:answer=numberA+numberB;
//        break;
//        case 1:answer=numberA-numberB;
//        break;
//        case 2:answer=numberA*numberB;
//        break;
//        default:
//            answer=(numberA*1.0)/numberB;
//    }
////    将用户输入的结果与答案比较
//        if(result==answer){
//            if(types.equals("student")) {
//                int studentId = 111;
//                String name="小明";
//                String phone="1234567890";
//                String school="重庆理工大学";
//                String userName="qwer";
//                String passWord="123456";
//                Student student = new Student(studentId, name, phone, school, userName, passWord);
//                studentService.insertStudent(student);
//                return "注册成功！";
//            }
//            else {
//                int teacherId=222;
//                String name="王传芳";
//                String email="12313242";
//                String school="重庆理工大学";
//                String userName="qwer";
//                String passWord="123456";
//                Teacher teacher=new Teacher(teacherId,name,email,school,userName,passWord);
//                teacherService.insertTeacher(teacher);
//                return "注册成功！";
//            }
//        }
//        else {
//            return "验证码错误！";
//        }
//    }

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
    public String enRollTest(@RequestBody String[] condition){
       String inputVerCode=condition[5];

        String types="student";


//    将用户输入的结果与验证码比较
        if(inputVerCode.equals(verifyCode)){
            if(types.equals("student")) {
                int studentId = Integer.parseInt(condition[0]);
                String name=condition[1];
                String phone=condition[2];
                String school=condition[3];
                String userName="";
                String passWord=condition[4];
                Student student = new Student(studentId, name, phone, school, userName, passWord);
                studentService.insertStudent(student);
                return "注册成功！";
            }
            else {
                int teacherId=Integer.parseInt(condition[0]);
                String name=condition[1];
                String email=condition[2];
                String school=condition[3];
                String userName="";
                String passWord=condition[4];
                Teacher teacher=new Teacher(teacherId,name,email,school,userName,passWord);
                teacherService.insertTeacher(teacher);
                return "注册成功！";
            }
        }
        else {
            return "验证码错误！";
        }
    }


}
