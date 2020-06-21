package com.example.demo.dao;

import com.example.demo.entity.WorkStudentFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface WorkStudentFileMapper {

//    查询全部学生作业提交的文件
    List<WorkStudentFile> selectAllWorkStudentFile();

//    根据课程号和学号 查找指定学生在指定课程提交的作业文件
    List<WorkStudentFile> selectWorkStudentFileByCS(int workId,int studentId);

    //    学生作业提交文件
    void insertWorkFile(int workId, int studentId,String fileName);
}