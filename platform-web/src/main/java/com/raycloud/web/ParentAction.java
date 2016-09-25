package com.raycloud.web;


import com.raycloud.dao.StudentInfoDao;
import com.raycloud.dao.StudentSchoolLogDao;
import com.raycloud.module.exception.ServiceException;
import com.raycloud.module.pojo.StudentInfo;
import com.raycloud.module.pojo.StudentSchoolLog;
import com.raycloud.module.request.StudentSchoolLogListGetRequest;
import com.raycloud.module.response.Response;
import com.raycloud.module.response.ViewStudentSchoolLogList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 家长接口
 * Created by linjunjie on 2016/1/25 (linjunjie@raycloud.com).
 */
@Controller
public class ParentAction extends BaseAction{

    @Autowired
    private StudentInfoDao studentInfoDao;

    @Autowired
    private StudentSchoolLogDao studentSchoolLogDao;

    /**
     * 家长获取学生日志
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getChildByStudyNo")
    @ResponseBody
    public Object getChildByStudyNo(StudentSchoolLogListGetRequest request)throws Exception{
        Response response = new Response(request);
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudyNo(request.getStudyNo());
        studentInfo = studentInfoDao.get(studentInfo);
        if(studentInfo == null){
            throw new ServiceException("学号不存在!",902);
        }
        List<StudentSchoolLog> studentSchoolLogList = null;
        Integer total = 0;
        StudentSchoolLog studentSchoolLog = new StudentSchoolLog();
        try{
            //分页查询
            studentSchoolLog.setStartRow((request.getPageNo() - 1)*request.getPageSize());
            studentSchoolLog.setPageSize(request.getPageSize());
            studentSchoolLog.setStudyNo(request.getStudyNo());//根据学号搜索
            studentSchoolLog.orderByCreated(true);

            studentSchoolLogList = studentSchoolLogDao.getList(studentSchoolLog);
            total = studentSchoolLogDao.getCount(studentSchoolLog);

            ViewStudentSchoolLogList view = new ViewStudentSchoolLogList();
            view.toResponse(studentSchoolLogList);
            List<ViewStudentSchoolLogList.StudentDayLogListBean> list =
                    view.getStudentDayLogList();
            if(studentSchoolLogList != null && studentSchoolLogList.size() > 0){
                for(ViewStudentSchoolLogList.StudentDayLogListBean s : list){
                    s.setRealName(studentInfo.getRealName());
                }
            }
            //返回信息
            view.setTotal(total);
            view.setPageNo(request.getPageNo());
            view.setPageSize(request.getPageSize());
            response.setData(view);
        }catch(Exception e){
            throw new ServiceException("获取学生日志列表失败",902,e);
        }
        return response;
    }

}
