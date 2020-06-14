package com.example.demo.serviceImp;


import com.example.demo.dao.WorkMapper;
import com.example.demo.entity.Work;
import com.example.demo.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//实现类
@Service
public class WorkServiceImp implements WorkService {


    @Autowired(required = false)
    WorkMapper workMapper;


    @Override
    public List<Work> selectAllWork() {
        return workMapper.selectAllWork();
    }

    @Override
    public void insertWork(Work work) {
        workMapper.insertWork(work);
    }

    @Override
    public List<Work> selectWorkByWorkId(int workId) {
        return workMapper.selectWorkByWorkId(workId);
    }

    @Override
    public List<Work> selectWorkByCourse(int courseId) {
        return workMapper.selectWorkByCourse(courseId);
    }

    @Override
    public void studentSubmitWork(int workId) {
        workMapper.studentSubmitWork(workId);
    }

    @Override
    public void teacherCheckWork(int workId) {
        workMapper.teacherCheckWork(workId);
    }
}
