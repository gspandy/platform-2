package com.raycloud.web;

import com.raycloud.dao.StudentInfoDao;
import com.raycloud.dao.StudentSchoolLogDao;
import com.raycloud.module.exception.ServiceException;
import com.raycloud.module.pojo.StudentInfo;
import com.raycloud.module.pojo.User;
import com.raycloud.module.request.Request;
import com.raycloud.module.request.StudentListGetRequest;
import com.raycloud.module.response.Response;
import com.raycloud.module.response.ViewStudentList;
import com.raycloud.module.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/8/23.
 */
@Controller
public class StudentInfoAction extends BaseAction {

    @Autowired
    private StudentSchoolLogDao studentSchoolLogDao;

    @Autowired
    private StudentInfoDao studentInfoDao;

    /**
     * 获取学生列表
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getStudentList")
    public Response getStudentList(StudentListGetRequest request)throws Exception {
        Response response = new Response(request);
        List<StudentInfo> studentInfoList = null;
        Integer total = 0;
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudyNo(request.getStudyNo());
        studentInfo.setUserId(request.getUserId());
        studentInfo.setRealName(request.getRealName());
        studentInfo.setTrain(request.getTrain());
        User user = getUser();

        try{
            //分页查询
            studentInfo.setStartRow((request.getPageNo() - 1)*request.getPageSize());
            studentInfo.setPageSize(request.getPageSize());
            if(user.getId() == 1){
                //超级管理员
                studentInfoList = studentInfoDao.getList(studentInfo);
                total = studentInfoDao.getCount(studentInfo);
            }else{
                //幼儿园用户
                studentInfo.setUserId(user.getId());
                studentInfoList = studentInfoDao.getList(studentInfo);
                total = studentInfoDao.getCount(studentInfo);
            }
            ViewStudentList view = new ViewStudentList();
            view.toResponse(studentInfoList);
            view.setTotal(total);
            view.setPageNo(request.getPageNo());
            view.setPageSize(request.getPageSize());
            response.setData(view);
        }catch(Exception e){
            throw new ServiceException("获取学生列表失败",902,e);
        }

        return response;
    }

    /**
     * 保存学生
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/saveStudent")
    public Response saveStudent(StudentInfo studentInfo,Request request)throws Exception {
        Response response = new Response(request);
        User user = getUser();
        studentInfo.setBirthday(DateUtil.getDateTime(studentInfo.getBirthday_(),DateUtil.DATE_FORMAT));
        if(studentInfo.getId() != null && studentInfo.getId() != 0){
            //修改
            StudentInfo exist = studentInfoDao.existStudyNo(studentInfo);
            if(exist != null && exist.getId().longValue() != studentInfo.getId().longValue()){
                throw new ServiceException("学号已经存在！",902);
            }
            studentInfoDao.update(studentInfo);

        }else{
            //插入
            studentInfo.setUserId(user.getId());
            //计算学号
            studentInfo.setStudyNo(user.getPreNo() +
                    studentInfo.getStudyNo());
            StudentInfo exist = studentInfoDao.existStudyNo(studentInfo);
            if(exist != null){
                throw new ServiceException("学号已经存在！",902);
            }
            studentInfoDao.add(studentInfo);
        }


        return response;
    }

    /**
     * 删除学生信息
     * @param studentInfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/removeStudent")
    public Response removeStudent(StudentInfo studentInfo,Request request)throws Exception {
        Response response = new Response(request);
        User user = getUser();
        if(user.getId() == null || user.getId() != 1){
            studentInfo.setUserId(user.getId());
        }
        Integer count = studentInfoDao.delete(studentInfo);
        if (count <= 0) {
            throw new ServiceException("请勿重复删除!", 902);
        }

        return response;
    }

    /**
     * 获得学生信息
     * @param studentInfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getStudent")
    public Response getStudent(StudentInfo studentInfo,Request request)throws Exception {
        Response response = new Response(request);
        User user = getUser();
        if(user.getId() != 1){
            studentInfo.setUserId(user.getId());
        }
        studentInfo = studentInfoDao.get(studentInfo);
        studentInfo.setBirthday_(DateUtil.getDateTime(studentInfo.getBirthday(),DateUtil.DATE_FORMAT));
        if (studentInfo == null) {
            throw new ServiceException("该学生信息已不存在!", 902);
        }
        response.setData(studentInfo);
        return response;
    }

    /**
     * 标记学生为提高训练
     * @param studentInfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/tagStudent")
    public Response tagStudent(StudentInfo studentInfo,Request request)throws Exception {
        Response response = new Response(request);
        User user = getUser();
        studentInfo = studentInfoDao.get(studentInfo);
        if(studentInfo != null){
            StudentInfo temp = new StudentInfo();
            temp.setId(studentInfo.getId());
            if(studentInfo.getTrain() == 1){
                temp.setTrain(0);
            }else{
                temp.setTrain(1);
            }
            studentInfoDao.update(temp);
        }else{
            throw new ServiceException("该学生信息已被删除,无法标记",902);
        }

        return response;
    }

}
