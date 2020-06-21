package com.example.demo.serviceImp;

import com.example.demo.dao.CourseStudentMapper;
import com.example.demo.entity.CourseStudent;
import com.example.demo.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//实现类
@Service
public class CourseStudentServiceImp implements CourseStudentService {


    @Autowired(required = false)
    CourseStudentMapper courseStudentMapper;

//查询全部学生选课信息
    @Override
    public List<CourseStudent> selectAllCourseStudent() {
        return courseStudentMapper.selectAllCourseStudent();
    }

    @Override
    public void insertCourseStudent(CourseStudent courseStudent) {
        courseStudentMapper.insertCourseStudent(courseStudent);
    }

    @Override
    public void deleteCourseSrudent(int id) {
        courseStudentMapper.deleteCourseSrudent(id);
    }

    @Override
    public List<CourseStudent> selectCourseStudentByCourseId(int courseId) {
        return courseStudentMapper.selectCourseStudentByCourseId(courseId);
    }

    @Override
    public void updateOneArchive(int courseId, int studentId) {
        courseStudentMapper.updateOneArchive(courseId,studentId);
    }

    @Override
    public void updateAllArchive(int courseId) {
        courseStudentMapper.updateAllArchive(courseId);
    }
}
