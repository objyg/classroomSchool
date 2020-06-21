package com.example.demo.serviceImp;


import com.example.demo.dao.CourseTeacherMapper;
import com.example.demo.entity.CourseTeacher;
import com.example.demo.service.CourseTeacherService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//实现类
@Service
public class CourseTeacherServiceImp implements CourseTeacherService {


    @Autowired(required = false)
    CourseTeacherMapper courseTeacherMapper;

    @Override
    public List<CourseTeacher> selectAllCourseTeacher() {
        return courseTeacherMapper.selectAllCourseTeacher();
    }

    @Override
    public void insertCourseTeacher(CourseTeacher courseTeacher) {
        courseTeacherMapper.insertCourseTeacher(courseTeacher);
    }

    @Override
    public void deleteCourseTeacher(int courseId,int teacherId) {
        courseTeacherMapper.deleteCourseTeacher(courseId,teacherId);
    }

    @Override
    public void updateOneArchive(int courseId, int teacherId) {
        courseTeacherMapper.updateOneArchive(courseId,teacherId);
    }

    @Override
    public void updateAllArchive(int courseId) {
        courseTeacherMapper.updateAllArchive(courseId);
    }
}
