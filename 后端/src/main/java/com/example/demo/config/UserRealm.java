package com.example.demo.config;


import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
//        给资源授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        Subject subject= SecurityUtils.getSubject();
        Student student=(Student)subject.getPrincipal();

//        添加资源授权字符串
//        info.addStringPermission(user.getPerms());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

//        判断
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;

//        判断是学生还是老师
        String types=token.getHost();
        if(types.equals("student")){
            //        判断账号
            Student student=studentService.selectStudentByUserName(token.getUsername());

            if(student==null){
//            没有此账号
                return null;
            }

            return new SimpleAuthenticationInfo(student,student.getPassword(),"");
        }


        else {
            //        判断账号
            Teacher teacher=teacherService.selectTeacherByUserName(token.getUsername());
            if(teacher==null){
//            没有此账号
                throw new UnknownAccountException();
            }




            return new SimpleAuthenticationInfo(teacher,teacher.getPassword(),"");
        }


    }
}
