package com.example.demo.service;



import com.example.demo.entity.Work;
import com.example.demo.entity.WorkStudent;

import java.util.List;

public interface WorkStudentService {
     //    查询全部学生提交作业信息
     List<WorkStudent> selectALLWorkStudent();

     //    学生提交作业
     void insertWorkStudent(WorkStudent workStudent);

     //    教师批改作业
     void teacherCheckWork(int workId,int studentId,int score);

     //    教师发布作业，学生作业加一条
     void issueWork(int workId,int studentId);
}
