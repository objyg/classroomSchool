package com.example.demo.serviceImp;

import com.example.demo.dao.CourseFileMapper;
import com.example.demo.entity.CourseFile;
import com.example.demo.service.CourseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//实现类
@Service
public class CourseFileServiceImp implements CourseFileService {


    @Autowired(required = false)
    CourseFileMapper courseFileMapper;


    @Override
    public List<CourseFile> selectAllCourseFile() {
        return courseFileMapper.selectAllCourseFile();
    }

    @Override
    public List<CourseFile> selectCourseFileByCourseId(int courseId) {
        return courseFileMapper.selectCourseFileByCourseId(courseId);
    }

    @Override
    public void insertCourseFile(int courseId, String fileName) {
        courseFileMapper.insertCourseFile(courseId,fileName);
    }
}
