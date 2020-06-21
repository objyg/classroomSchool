package com.example.demo.dao;

import com.example.demo.entity.Work;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface WorkMapper {


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

//    教师发布作业时，将未交人数修改为学习这门课程的学生人数
    void updateUnSubmit(int workId,int number);
}