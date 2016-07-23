package com.raycloud.web;

import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.User;
import com.raycloud.request.*;
import com.raycloud.response.Response;
import com.raycloud.response.ViewCourseList;
import com.raycloud.response.ViewTeacherList;
import com.raycloud.response.ViewTrainingInformation;
import com.raycloud.service.impl.PublicService;
import com.raycloud.util.StringUtil;
import org.apache.http.auth.AUTH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by on 2016/5/10.
 */
@Controller
@RequestMapping("/ufree")
public class PublicAction extends BaseAction {

    @Autowired
    private PublicService publicService;


    /**
     * 获取机构信息
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getTrainingInformation/{username}")
    public Response getTrainingInformation(TrainingInformationGetRequest request)throws Exception{
        Response response = new Response(request);
        ViewTrainingInformation view = publicService.getTrainingInformation(request);
        response.setData(view);
        return response;
    }

    /**
     * 保存logo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/updateLogoPic")
    public Response updateLogoPic(TrainingLogoPicUpdateRequest request)throws Exception{
        Response response = new Response(request);
        if(request.getLogoPic().getSize() > 524288){
            throw new ServiceException("图片不能超过512kb",902);
        }
        publicService.updateLogoPic(request,getUser());
        return response;
    }



    /**
     * 修改机构信息
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/updateTrainingInformation")
    public Response updateTrainingInformation(TrainingInformationUpdateRequest request)throws Exception{
        Response response = new Response(request);
        StringUtil.objFilter(request);
        publicService.updateTrainingInformation(request, getUser());
        return response;
    }

    /**
     * 添加老师
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addTeacher")
    public Response addTeacher(TeacherAddRequest request)throws Exception{
        Response response = new Response(request);
        StringUtil.objFilter(request);
        publicService.addTeacher(request, getUser());
        return response;
    }

    /**
     * 获取老师列表
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getTeacherList/{username}")
    public Response getTeacherList(TeacherListGetRequest request)throws Exception{
        Response response = new Response(request);
        ViewTeacherList view = publicService.getTeacherList(request);
        response.setData(view);
        return response;
    }

    /**
     * 获取课程列表
     * @param request
     */
    @ResponseBody
    @RequestMapping("/getCourseList/{username}")
    public Response getCourseList(CourseListGetRequest request)throws Exception{
        Response response = new Response(request);
        ViewCourseList view = publicService.getCourseList(request);
        response.setData(view);
        return response;
    }

    /**
     * 添加课程
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addCourse")
    public Response addCourse(CourseAddRequest request)throws Exception{
        Response response = new Response(request);
        publicService.addCourse(request,getUser());
        return response;
    }

    /**
     * 移除课程
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/removeCourse/{id}")
    public Response removeCourse(CourseRemoveRequest request)throws Exception{
        Response response = new Response(request);
        publicService.removeCourse(request,getUser());
        return response;
    }


    /**
     * 添加文章
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addArticle")
    public Response addArticle(ArticleAddRequest request)throws Exception{
        Response response = new Response(request);
        publicService.addArticle(request,getUser());
        return response;
    }

}
