package com.example.demo.service;




import com.example.demo.entity.CourseFile;

import java.util.List;

public interface CourseFileService {

     //    查询全部资料
     List<CourseFile> selectAllCourseFile();

     //    根据课程id查询该课程的资料
     List<CourseFile> selectCourseFileByCourseId(int courseId);

     //    添加资料
     void insertCourseFile(int courseId, String fileName);


}

