package com.raycloud.web;

import com.raycloud.dao.UserDao;
import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.User;
import com.raycloud.request.InstitutionListGetRequest;
import com.raycloud.request.Request;
import com.raycloud.request.UserRegisterRequest;
import com.raycloud.response.Response;
import com.raycloud.response.ViewUserList;
import com.raycloud.response.ViewUserLoginInfo;
import com.raycloud.service.impl.PublicService;
import com.raycloud.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/7.
 */
@Controller
@RequestMapping("/admin")
public class AdminAction extends BaseAction {

    @Autowired
    private PublicService publicService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    /**
     * 管理员为机构分配账号(幼儿园)
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addInstitution")
    public Response addInstitution(UserRegisterRequest request)throws Exception {
        Response response = new Response(request);
        System.out.println("幼儿园账号添加");
        boolean status = false;
        userService.addInstitution(request,getRequest());
        ViewUserLoginInfo viewUserLoginInfo = new ViewUserLoginInfo();
        viewUserLoginInfo.setUsername(request.getUsername());
        response.setData(viewUserLoginInfo);
        return response;
    }

    /**
     * 获取机构列表
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getInstitutionList")
    public Response getInstitutionList(InstitutionListGetRequest request)throws Exception {
        Response response = new Response(request);
        boolean status = false;
        ViewUserList view = userService.getInstitutionList(request);
        response.setData(view);
        return response;
    }

    /**
     * 开关机构账号状态
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/switchInstitution")
    public Response switchInstitution(Long id,Request request)throws Exception {
        Response response = new Response(request);
        User user = new User();
        user.setId(id);
        user = userDao.get(user);
        if(user == null){
            throw new ServiceException("机构信息不存在",902);
        }
        if(user.getStatus() == 1){
            user.setStatus(0);
            userDao.update(user);
        }else if(user.getStatus() == 0){
            user.setStatus(1);
            userDao.update(user);
        }
        return response;
    }

}
