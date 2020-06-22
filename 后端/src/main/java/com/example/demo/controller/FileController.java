package com.example.demo.controller;


import com.example.demo.entity.Course;
import com.example.demo.entity.CourseFile;
import com.example.demo.entity.WorkStudentFile;
import com.example.demo.service.CourseFileService;
import com.example.demo.service.CourseService;
import com.example.demo.service.WorkStudentFileService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;


//调用接口
@CrossOrigin
@RestController
@RequestMapping("/FileController")
public class FileController {

    @Autowired
    CourseFileService courseFileService;

    @Autowired
    WorkStudentFileService workStudentFileService;

//    查询全部学生提交作业资料
    @GetMapping("/getAllWorkStudentFile")
    public List<WorkStudentFile> getAllWorkStudentFile(){
        return workStudentFileService.selectAllWorkStudentFile();
    }

//   根据课程号和学号 查找指定学生在指定课程提交的作业文件
    @PostMapping("/selectWorkStudentFileByCS")
    public List<WorkStudentFile> selectWorkStudentFileByCS(@RequestBody int[] condition){
        return workStudentFileService.selectWorkStudentFileByCS(condition[0],condition[1]);
    }

    //    查询全课程资料信息
    @GetMapping("/getAllCourseFile")
    public List<CourseFile> selectAllCourseFile(){
        return courseFileService.selectAllCourseFile();
    }


    //    根据课程号查找该课程的资料
    @PostMapping("/selectCourseFileByCourseId")
    public List<CourseFile> selectCourseFileByCourseId(@RequestBody int courseId){
        return courseFileService.selectCourseFileByCourseId(courseId);
    }


//    学生作业文件上传
@RequestMapping("/workFileUpload")
public void workFileUpload(HttpServletRequest request) throws IOException {

    MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
    List<MultipartFile> files = ((MultipartHttpServletRequest) request)
            .getFiles("files");
    MultipartFile file=files.get(0);
//    System.out.println(file.getOriginalFilename());
    String workId=params.getParameter("workId");
    String studentId=params.getParameter("studentId");
    //获取上传文件的路径
    String realPath = "D://唐圳//软件学习//高级java//作业//课程设计//课堂派//后端（git）//classroomSchool//后端//srcmain//java//com//example//demo//file";
    //获取上传的文件名，
    File file1 = new File(realPath, file.getOriginalFilename());
//    System.out.println(files.getOriginalFilename());
    workStudentFileService.insertWorkFile(Integer.parseInt(workId),Integer.parseInt(studentId),file.getOriginalFilename());
    //执行文件上传复制
    file.transferTo(file1);

}

//学生作业文件下载
@RequestMapping("/workFileDownload")
public void workFileDownload(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
//        获取文件路径
    String uploadPath = "D://唐圳//软件学习//高级java//作业//课程设计//课堂派//后端（git）//classroomSchool//后端//srcmain//java//com//example//demo//file";
    File file = new File(uploadPath,fileName);
    if(file.exists()){
        response.setContentType("application/octet-stream");
        response.setHeader("content-type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName,"utf8"));
        byte[] buffer = new byte[1024];
        //输出流
        OutputStream os = null;
        try(FileInputStream fis= new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);) {
            os = response.getOutputStream();
            int i = bis.read(buffer);
            while(i != -1){
                os.write(buffer);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



    //    课程资料文件上传
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/courseFileUpload")
    public void courseFileUpload(HttpServletRequest request) throws IOException {

        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("files");
        MultipartFile file=files.get(0);
        String courseId=params.getParameter("courseId");
        //获取上传文件的路径
        String realPath = "D://唐圳//软件学习//高级java//作业//课程设计//课堂派//后端（git）//classroomSchool//后端//srcmain//java//com//example//demo//file";
//        System.out.println("--------"+realPath);
        //获取上传的文件名，
        File file1 = new File(realPath, file.getOriginalFilename());
//        System.out.println(file.getOriginalFilename());
        courseFileService.insertCourseFile(Integer.parseInt(courseId),file.getOriginalFilename());
        //执行文件上传复制
        file.transferTo(file1);
        //跳到下载页面

    }


    //课程资料文件下载
    @RequestMapping("/courseFileDownload")
    public void courseFileDownload(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
//        获取文件路径
        String uploadPath = "D://唐圳//软件学习//高级java//作业//课程设计//课堂派//后端（git）//classroomSchool//后端//srcmain//java//com//example//demo//file";
        File file = new File(uploadPath,fileName);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName,"utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try(FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
