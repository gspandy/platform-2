package com.raycloud.web;

import com.raycloud.request.TeacherAddRequest;
import com.raycloud.request.TeacherListGetRequest;
import com.raycloud.request.TrainingInformationGetRequest;
import com.raycloud.request.TrainingInformationUpdateRequest;
import com.raycloud.response.Response;
import com.raycloud.response.ViewTeacherList;
import com.raycloud.response.ViewTrainingInformation;
import com.raycloud.service.impl.PublicService;
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
     * 修改机构信息
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/updateTrainingInformation")
    public Response updateTrainingInformation(TrainingInformationUpdateRequest request)throws Exception{
        Response response = new Response(request);
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
        publicService.addTeacher(request, getUser());
        return response;
    }

    @ResponseBody
    @RequestMapping("/getTeacherList/{username}")
    public Response getTeacherList(TeacherListGetRequest request)throws Exception{
        Response response = new Response(request);
        ViewTeacherList view = publicService.getTeacherList(request);
        response.setData(view);
        return response;
    }
    

}
