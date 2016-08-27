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
import com.raycloud.util.MD5Utils;
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
    @RequestMapping("/saveInstitution")
    public Response saveInstitution(UserRegisterRequest request)throws Exception {
        Response response = new Response(request);
        if(request.getId() == null || request.getId() == 0 ){
            //新增
            userService.addInstitution(request,getRequest());
        }else{
            //修改
            User user = new User();
            user.setId(request.getId());
            user.setUsername(request.getUsername());
            user.setPreNo(request.getPreNo());
            user.setInstitution(request.getInstitution());
            user.setOwner(request.getOwner());
            user.setPhone(request.getPhone());
            //密码
            if(request.getPassword() != null && !"".equals(request.getPassword().trim())){
                user.setPassword(MD5Utils
                        .toHexString(MD5Utils.encodeByMD5(request.getPassword().getBytes())));
            }
            userDao.update(user);
        }

        ViewUserLoginInfo viewUserLoginInfo = new ViewUserLoginInfo();
        viewUserLoginInfo.setUsername(request.getUsername());
        response.setData(viewUserLoginInfo);
        return response;
    }

    /**
     * 获得机构信息
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getInstitution")
    public Response getInstitution(Request request,User user)throws Exception {
        Response response = new Response(request);

        user = userDao.get(user);
        if(user == null){
            throw new ServiceException("用户已经不存在!",902);
        }
        user.setPassword(null);
        response.setData(user);
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
