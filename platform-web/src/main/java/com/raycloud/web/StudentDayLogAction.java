package com.raycloud.web;

import com.raycloud.dao.StudentInfoDao;
import com.raycloud.dao.StudentSchoolLogDao;
import com.raycloud.dao.UserDao;
import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.StudentInfo;
import com.raycloud.pojo.StudentSchoolLog;
import com.raycloud.pojo.User;
import com.raycloud.request.Request;
import com.raycloud.request.StudentSchoolLogListGetRequest;
import com.raycloud.request.UserLoginRequest;
import com.raycloud.response.Response;
import com.raycloud.response.ViewStudentSchoolLogList;
import com.raycloud.response.ViewUserLoginInfo;
import com.raycloud.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/8/23.
 */
@Controller
public class StudentDayLogAction extends BaseAction {

    @Autowired
    private StudentSchoolLogDao studentSchoolLogDao;

    @Autowired
    private StudentInfoDao studentInfoDao;

    /**
     * 获取学生日志列表
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getStudentDayLogList")
    public Response getStudentDayLogList(StudentSchoolLogListGetRequest request)throws Exception {
        Response response = new Response(request);
        List<StudentSchoolLog> studentSchoolLogList = null;
        Integer total = 0;
        StudentSchoolLog studentSchoolLog = new StudentSchoolLog();
        User user = getUser();
        try{
            //分页查询
            studentSchoolLog.setStartRow((request.getPageNo() - 1)*request.getPageSize());
            studentSchoolLog.setPageSize(request.getPageSize());
            studentSchoolLog.setStudyNo(request.getStudyNo());//根据学号搜索
            studentSchoolLog.orderByCreated(true);
            if(user.getId() == 1){
                //超级管理员
                studentSchoolLogList = studentSchoolLogDao.getList(studentSchoolLog);
                total = studentSchoolLogDao.getCount(studentSchoolLog);
            }else{
                //幼儿园用户
                //studentSchoolLog.setUserId(user.getId());   不需要，因为家长们也要调用此接口

                studentSchoolLogList = studentSchoolLogDao.getList(studentSchoolLog);
                total = studentSchoolLogDao.getCount(studentSchoolLog);
            }
            ViewStudentSchoolLogList view = new ViewStudentSchoolLogList();
            view.toResponse(studentSchoolLogList);
            List<ViewStudentSchoolLogList.StudentDayLogListBean> list =
                    view.getStudentDayLogList();
            StudentInfo tstu = null;
            if(studentSchoolLogList != null && studentSchoolLogList.size() > 0){
                tstu = new StudentInfo();
                tstu.setStudyNo(request.getStudyNo());
                tstu = studentInfoDao.get(tstu);
                for(ViewStudentSchoolLogList.StudentDayLogListBean s : list){
                    s.setRealName(tstu.getRealName());
                }
            }

            view.setTotal(total);
            view.setPageNo(request.getPageNo());
            view.setPageSize(request.getPageSize());
            response.setData(view);
        }catch(Exception e){
            throw new ServiceException("获取学生日志列表失败",902,e);
        }

        return response;
    }

    /**
     * 保存学生日志
     * @param studentSchoolLog
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/saveStudentDayLog")
    public Response saveStudentDayLog(StudentSchoolLog studentSchoolLog,
                                     Request request)throws Exception {
        Response response = new Response(request);
        User user = getUser();
        if(studentSchoolLog.getId() != null && studentSchoolLog.getId() != 0){
            //修改
            studentSchoolLogDao.update(studentSchoolLog);
        }else{
            //新增
            studentSchoolLog.setUserId(user.getId());
            studentSchoolLogDao.add(studentSchoolLog);
        }

        return response;
    }

    /**
     * 删除学生日志
     * @param studentSchoolLog
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/removeStudentDayLog")
    public Response removeStudentDayLog(StudentSchoolLog studentSchoolLog,
                                     Request request)throws Exception {
        Response response = new Response(request);
        User user = getUser();
        studentSchoolLog.setUserId(user.getId());
        Integer count = studentSchoolLogDao.delete(studentSchoolLog);
        if(count <= 0){
            throw new ServiceException("请勿重复删除!",902);
        }
        return response;
    }

    /**
     * 获取学生日志
     * @param studentSchoolLog
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getStudentDayLog")
    public Response getStudentDayLog(StudentSchoolLog studentSchoolLog,
                                        Request request)throws Exception {
        Response response = new Response(request);
        User user = getUser();
        studentSchoolLog.setUserId(user.getId());
        studentSchoolLog = studentSchoolLogDao.get(studentSchoolLog);
        response.setData(studentSchoolLog);
        return response;
    }



}
