package com.raycloud.service.impl;

import com.raycloud.constant.WebContextConstant;
import com.raycloud.dao.TeacherInfoDao;
import com.raycloud.dao.UserDao;

import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.TeacherInfo;
import com.raycloud.pojo.User;
import com.raycloud.qiniu.QiniuUtils;
import com.raycloud.request.TeacherAddRequest;
import com.raycloud.request.TeacherListGetRequest;
import com.raycloud.request.TrainingInformationGetRequest;
import com.raycloud.request.TrainingInformationUpdateRequest;
import com.raycloud.response.ViewTeacherList;
import com.raycloud.response.ViewTrainingInformation;
import com.raycloud.util.ContentTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/3.
 */
@Service
public class PublicService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    /**
     * 获取机构信息
     *
     * @param request
     * @throws ServiceException
     */
    public ViewTrainingInformation getTrainingInformation(TrainingInformationGetRequest request)throws ServiceException {
        User user = new User();
        user.setUsername(request.getUsername());
        user = userDao.get(user);
        if(user == null){
            throw new ServiceException("商户不存在",902);
        }
        ViewTrainingInformation trainingInformationResponse = new ViewTrainingInformation();
        trainingInformationResponse.setAddressDetail(user.getAddressDetail());
        trainingInformationResponse.setAddressCode(user.getAddressCode());
        trainingInformationResponse.setBusinessCode(user.getBusinessCode());
        trainingInformationResponse.setDesc(user.getDesc());
        trainingInformationResponse.setInsititution(user.getInstitution());
        trainingInformationResponse.setLogoPicUrl(user.getLogoPicUrl());
        trainingInformationResponse.setContactHotline(user.getContactHotline());

        return trainingInformationResponse;
    }

    /**
     * 保存培训信息
     * @param request
     */
    public void updateTrainingInformation(TrainingInformationUpdateRequest request,User user)throws ServiceException{
        try {
            User newInformation = new User();
            newInformation.setId(user.getId());
            newInformation.setInstitution(request.getInstitution());
            newInformation.setContactHotline(request.getContactHotline());
            newInformation.setDesc(request.getDesc());
            newInformation.setAddressCode(request.getAddressCode());
            newInformation.setAddressDetail(request.getAddressDetail());
            newInformation.setBusinessCode(request.getBusinessCode());
            userDao.update(newInformation);
        }catch(Exception e){
            throw new ServiceException(MessageFormat.format("保存信息失败,username:{0}",new Object[]{user.getUsername()}),902,e);
        }
    }

    /**
     * 添加老师
     * @param request
     * @param user
     */
    public void addTeacher(TeacherAddRequest request,User user)throws ServiceException{
        //1.存储图片
        if(request.getHeadPic() == null){
            throw new ServiceException("head_pic参数异常",902);
        }
        int index = request.getHeadPic().getOriginalFilename().indexOf(".");
        StringBuilder fileName = null;
        fileName = new StringBuilder((index == -1? request.getHeadPic().getOriginalFilename():request.getHeadPic().getOriginalFilename().substring(0,index)));
        String suffix = ContentTypeUtil.getExtension(request.getHeadPic().getContentType());
        if("".equals(suffix)){
            throw new ServiceException("图片格式错误!",902);
        }
        fileName.append(System.currentTimeMillis()).append(suffix);
        String savePath = null;
        savePath = new StringBuilder(WebContextConstant.webRealPath).append("/resources/upload/").append(fileName).toString();
        File file = new File(savePath);
        try {
            request.getHeadPic().transferTo(file);
        } catch (IOException e) {
            throw new ServiceException("服务器无法存储该图片",902,e);
        }
        try {
            QiniuUtils.getInstance().upload(fileName.toString(),savePath);
        } catch (IOException e) {
            throw new ServiceException("七牛云无法存储该图片",902,e);
        }
        if(file != null) {
            file.delete();
        }
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setUserId(user.getId());
        teacherInfo.setDesc(request.getDesc());
        teacherInfo.setRealName(request.getRealName());
        teacherInfo.setHeadPicUrl(fileName.toString());
        teacherInfo.setAuthenticate(0);
        teacherInfo.setStatus(1);
        teacherInfoDao.add(teacherInfo);

    }

    /**
     * 获取老师的列表
     * @throws ServiceException
     */
    public ViewTeacherList getTeacherList(TeacherListGetRequest request)throws ServiceException{
        User user = new User();
        user.setUsername(request.getUsername());
        user = userDao.get(user);
        if(user == null){
            throw new ServiceException("用户不存在",902);
        }
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setUserId(user.getId());
        List<TeacherInfo> teacherInfoList = teacherInfoDao.getList(teacherInfo);
        for(TeacherInfo item : teacherInfoList){
            if(item.getHeadPicUrl() != null)
                item.setHeadPicUrl(QiniuUtils.getInstance().getDownloadLink(item.getHeadPicUrl()));
            if(item.getTeacherAwardUrl() != null)
                item.setTeacherAwardUrl(QiniuUtils.getInstance().getDownloadLink(item.getTeacherAwardUrl()));
        }
        ViewTeacherList viewTeacherList = new ViewTeacherList();
        viewTeacherList.toResponse(teacherInfoList);


        return viewTeacherList;
    }

}
