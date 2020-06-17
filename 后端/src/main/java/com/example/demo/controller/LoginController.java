package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.loginResult.Result;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, md5PassWord,types);
        try {
            //shiro帮我们匹配密码什么的，我们只需要把东西传给它，它会根据我们在UserRealm里认证方法设置的来验证
            user.login(token);

//            判断是学生还是教师
            if(types.equals("student")){
                List<Student> studentList=studentService.studentLogin(userName,md5PassWord);
                result.setStudent(studentList.get(0));
            }
            else {
                List<Teacher> teacherList=teacherService.teacherLogin(userName,md5PassWord);
                result.setTeacher(teacherList.get(0));
            }

            result.setCode(200);
                result.setMessage("登陆成功！");
                return result;
        } catch (UnknownAccountException e) {
            //账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
            result.setCode(202);
                result.setMessage("账号错误！");
                return result;
        } catch (IncorrectCredentialsException e) {
                result.setCode(201);
                result.setMessage("密码错误！");
                return result;
        } catch (Throwable e) {
            result.setCode(203);
            result.setMessage("未知错误！");
            return result;
        }
    }

//    未登陆
    @RequestMapping("/NoLogin")
    public Result NoLogin(){
        Result result=new Result();
        result.setCode(999);
        result.setMessage("未登录！");
        return result;
    }


}



//        if(types.equals("student")) {
//            List<Student> studentList=studentService.studentLogin(userName,md5PassWord);
//            if (studentList.size() > 0) {
//                result.setCode(200);
//                result.setStudent(studentList.get(0));
//                result.setMessage("登陆成功！");
//                return result;
//            } else if (studentService.selectStudentByUserName(userName).size()>0){
//                result.setCode(201);
//                result.setMessage("密码错误！");
//                return result;
//            }
//            else {
//                result.setCode(202);
//                result.setMessage("用户名错误！");
//                return result;
//            }
//        }
//        else {
//            List<Teacher> teacherList=teacherService.teacherLogin(userName,md5PassWord);
//            if (teacherList.size() > 0) {
//                result.setCode(200);
//                result.setTeacher(teacherList.get(0));
//                result.setMessage("登陆成功！");
//                return result;
//            } else if (teacherService.selectTeacherByUserName(userName).size()>0){
//                result.setCode(201);
//                result.setMessage("密码错误！");
//                return result;
//            }
//            else {
//                result.setCode(202);
//                result.setMessage("用户名错误！");
//                return result;
//            }
//        }
