package com.example.demo.controller;


import com.example.demo.entity.Work;
import com.example.demo.entity.WorkStudent;
import com.example.demo.service.WorkService;
import com.example.demo.service.WorkStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//调用接口
@CrossOrigin
@RestController
@RequestMapping("/WorkStudentController")
public class WorkStudentController {

    @Autowired
    WorkStudentService workStudentService;

    @Autowired
    WorkService workService;

//    查找全部学生提交作业
    @GetMapping("/selectAllWorkStudent")
    public List<WorkStudent> selectAllWorkStudent(){
        return workStudentService.selectALLWorkStudent();
    }

//    学生提交作业
    @PostMapping("/insertWorkStudent")
    public void insertWorkStudent(@RequestBody WorkStudent workStudent){
        insertWorkStudent(workStudent);
//        该作业提交人数变化
        workService.studentSubmitWork(workStudent.getWorkid());
    }

//    教师批改作业
    @PostMapping("/teacherCheckWork")
    public void teacherCheckWork(@RequestBody int[] condition){
        workStudentService.teacherCheckWork(condition[0],condition[1]);
    }

}
