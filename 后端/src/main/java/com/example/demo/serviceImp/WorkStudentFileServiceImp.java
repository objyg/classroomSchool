package com.example.demo.serviceImp;


import com.example.demo.dao.WorkStudentFileMapper;
import com.example.demo.entity.WorkStudentFile;
import com.example.demo.service.WorkStudentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//实现类
@Service
public class WorkStudentFileServiceImp implements WorkStudentFileService {


    @Autowired(required = false)
    WorkStudentFileMapper workStudentFileMapper;


    @Override
    public List<WorkStudentFile> selectAllWorkStudentFile() {
        return workStudentFileMapper.selectAllWorkStudentFile();
    }

    @Override
    public List<WorkStudentFile> selectWorkStudentFileByCS(int workId, int studentId) {
        return workStudentFileMapper.selectWorkStudentFileByCS(workId,studentId);
    }

    @Override
    public void insertWorkFile(int workId, int studentId,String fileName) {
        workStudentFileMapper.insertWorkFile(workId,studentId,fileName);
    }
}

