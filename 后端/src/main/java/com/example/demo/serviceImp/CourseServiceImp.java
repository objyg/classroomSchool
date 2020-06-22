package com.example.demo.serviceImp;

import com.example.demo.dao.CourseMapper;
import com.example.demo.dao.CourseStudentMapper;
import com.example.demo.entity.Course;
import com.example.demo.entity.CourseStudent;
import com.example.demo.service.CourseService;
import com.example.demo.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//实现类
@Service
public class CourseServiceImp implements CourseService {


    @Autowired(required = false)
    CourseMapper courseMapper;

//查询全部课程信息
    @Override
    public List<Course> selectAllCourse() {
        return courseMapper.selectAllCourse();
    }

//    增加课程
    @Override
    public void insertCourse(Course course) {
        courseMapper.insertCourse(course);
    }

    @Override
    public List<Course> selectCourseByStudent(int studentId) {
        return courseMapper.selectCourseByStudent(studentId);
    }

    @Override
    public List<Course> selectCourseByTeacher(int teacherId) {
        return courseMapper.selectCourseByTeacher(teacherId);
    }

    @Override
    public List<Course> selectCourseByStudentNo(int studentId) {
        return courseMapper.selectCourseByStudentNo(studentId);
    }

    @Override
    public List<Course> selectCourseByTeacherNo(int teacherId) {
        return courseMapper.selectCourseByTeacherNo(teacherId);
    }


    @Override
    public void updateAllArchive(int courseId) {
        courseMapper.updateAllArchive(courseId);
    }

    @Override
    public void insertCourseNumber(int courseId) {
        courseMapper.insertCourseNumber(courseId);
    }


}
