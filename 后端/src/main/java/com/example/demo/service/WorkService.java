package com.example.demo.service;



import com.example.demo.entity.Work;

import java.util.List;

public interface WorkService {
     //    查询全部作业信息
     List<Work> selectAllWork();


     //    发布作业
     void insertWork(Work work);

     //    根据作业id查找指定作业信息
     List<Work> selectWorkByWorkId(int workId);

     //  查找指定课程的作业
     List<Work> selectWorkByCourse(int courseId);

     //    学生提交作业   上交人数+1    未交人数-1
     void studentSubmitWork(int workId);

     //    教师批改作业    已批改+1     未批改-1
     void teacherCheckWork(int workId);
}
