package com.example.demo.controller;


import com.example.demo.entity.CourseStudent;
import com.example.demo.entity.Work;
import com.example.demo.entity.WorkStudent;
import com.example.demo.service.CourseStudentService;
import com.example.demo.service.StudentService;
import com.example.demo.service.WorkService;
import com.example.demo.service.WorkStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//调用接口
@CrossOrigin
@RestController
@RequestMapping("/WorkController")
public class WorkController {

    @Autowired
    WorkService workService;

    @Autowired
    CourseStudentService courseStudentService;

    @Autowired
    WorkStudentService workStudentService;

//    查找全部作业信息
    @GetMapping("/getAllWork")
    public List<Work> selectAllWork(){
        return workService.selectAllWork();
    }

//    发布作业
    @PostMapping("/insertWork")
    public void insertWork(@RequestBody Work work){
        workService.insertWork(work);
//        教师发布作业，对应课程的所有学生都加一条作业
        List<CourseStudent> courseStudentList=courseStudentService.selectCourseStudentByCourseId(work.getCourseid());

//        更改作业的未交人数和未批改人数为选修该课程的学生人数
        workService.updateUnSubmit(work.getWorkid(),courseStudentList.size());
        for(CourseStudent courseStudent:courseStudentList){
            workStudentService.issueWork(work.getWorkid(),courseStudent.getStudentid());
        }
    }

//    根据作业id查找指定作业信息
    @PostMapping("/selectWorkByWorkId")
    public List<Work> selectWorkByWorkId(@RequestBody int workId){
        return workService.selectWorkByWorkId(workId);
    }

//  查找指定课程的作业
    @PostMapping("/selectWorkByCourse")
    public List<Work> selectWorkByCourse(@RequestBody int courseId){
        return workService.selectWorkByCourse(courseId);
    }

}
