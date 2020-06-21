package com.example.demo.serviceImp;


import com.example.demo.dao.WorkMapper;
import com.example.demo.dao.WorkStudentMapper;
import com.example.demo.entity.Work;
import com.example.demo.entity.WorkStudent;
import com.example.demo.service.WorkService;
import com.example.demo.service.WorkStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//实现类
@Service
public class WorkStudentServiceImp implements WorkStudentService {


    @Autowired(required = false)
    WorkStudentMapper workStudentMapper;


    @Override
    public List<WorkStudent> selectALLWorkStudent() {
        return workStudentMapper.selectALLWorkStudent();
    }

    @Override
    public void insertWorkStudent(WorkStudent workStudent) {
        workStudentMapper.insertWorkStudent(workStudent);
    }

    @Override
    public void teacherCheckWork(int workId, int studentId,int score) {
        workStudentMapper.teacherCheckWork(workId,studentId,score);
    }

    @Override
    public void issueWork(int workId, int studentId) {
        workStudentMapper.issueWork(workId,studentId);
    }
}
