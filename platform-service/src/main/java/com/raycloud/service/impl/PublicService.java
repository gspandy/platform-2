package com.raycloud.service.impl;

import com.raycloud.constant.ResponseResultConstant;
import com.raycloud.dao.*;
import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.*;
import com.raycloud.request.*;
import com.raycloud.response.ViewArticleList;
import com.raycloud.response.ViewCourseList;
import com.raycloud.response.ViewTeacherList;
import com.raycloud.response.ViewTrainingInformation;
import com.raycloud.util.qiniu.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CategoryDao categoryDao;

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
        trainingInformationResponse.setLogoPicUrl(com.raycloud.util.qiniu.QiniuUtils.getInstance().getDownloadLink(user.getLogoPicUrl()));
        trainingInformationResponse.setContactHotline(user.getContactHotline());

        return trainingInformationResponse;
    }

    /**
     * 保存logo
     * @param request
     * @param user
     */
    public void updateLogoPic(TrainingLogoPicUpdateRequest request,User user)throws ServiceException{
        if(request.getLogoPic() == null){
            throw new ServiceException("logo_pic参数异常",902);
        }
        String fileName = null;
        try {
            fileName = QiniuUtils.getInstance().uploadPic(request.getLogoPic());
        } catch (Exception e) {
            throw new ServiceException(ResponseResultConstant.resultString.get(ResponseResultConstant.PIC_UPLOAD_ERROR),902,e);
        }
        User oldInfo = new User();
        oldInfo.setId(user.getId());
        oldInfo.setLogoPicUrl(fileName);
        userDao.update(oldInfo);
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
        String fileName = null;
        try {
            fileName = QiniuUtils.getInstance().uploadPic(request.getHeadPic());
        } catch (Exception e) {
            throw new ServiceException(ResponseResultConstant.resultString.get(ResponseResultConstant.PIC_UPLOAD_ERROR),902,e);
        }

        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setUserId(user.getId());
        teacherInfo.setDesc(request.getDesc());
        teacherInfo.setRealName(request.getRealName());
        teacherInfo.setHeadPicUrl(fileName);
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
        int startRow = (request.getPageNo() - 1)*request.getPageSize();
        teacherInfo.setStartRow(startRow);
        teacherInfo.setPageSize(request.getPageSize());
        teacherInfo.setUserId(user.getId());
        List<TeacherInfo> teacherInfoList = teacherInfoDao.getList(teacherInfo);
        for(TeacherInfo item : teacherInfoList){
            if(item.getHeadPicUrl() != null)
                item.setHeadPicUrl(QiniuUtils.getInstance().getDownloadLink(item.getHeadPicUrl()));
            if(item.getTeacherAwardUrl() != null)
                item.setTeacherAwardUrl(QiniuUtils.getInstance().getDownloadLink(item.getTeacherAwardUrl()));
        }
        Integer count = teacherInfoDao.getCount(teacherInfo);
        ViewTeacherList viewTeacherList = new ViewTeacherList();
        viewTeacherList.toResponse(teacherInfoList);
        viewTeacherList.setTotal(count);

        return viewTeacherList;
    }

    /**
     * 获取课程列表
     * @param request
     * @throws ServiceException
     */
    public ViewCourseList getCourseList(CourseListGetRequest request)throws ServiceException{
        User user = new User();
        user.setUsername(request.getUsername());
        user = userDao.get(user);
        if(user == null){
            throw new ServiceException("用户不存在",902);
        }
        Course course = new Course();
        course.setUserId(user.getId());
        int startRow = (request.getPageNo() - 1)*request.getPageSize();
        course.setStartRow(startRow);
        course.setPageSize(request.getPageSize());
        List<Course> courseList = courseDao.getList(course);
        int total = courseDao.getCount(course);

        ViewCourseList view = new ViewCourseList();
        view.setTotal(total);
        view.toResponse(courseList);
        return view;
    }

    /**
     * 添加课程
     * @param request
     */
    public void addCourse(CourseAddRequest request,User user)throws ServiceException{
        if(request.getPicUrl() == null){
            throw new ServiceException("课程图片不能为空",902);
        }

        String fileName = null;
        try {
            fileName = QiniuUtils.getInstance().uploadPic(request.getPicUrl());
        } catch (Exception e) {
            throw new ServiceException(ResponseResultConstant.resultString.get(ResponseResultConstant.PIC_UPLOAD_ERROR),902,e);
        }
        Course course = new Course();
        course.setUserId(user.getId());
        course.setName(request.getName());
        course.setPicUrl(fileName);
        course.setCreated(new Date());
        course.setStatus(1);
        courseDao.add(course);

    }

    /**
     * 删除课程
     * @param request
     * @param user
     * @throws ServiceException
     */
    public void removeCourse(CourseRemoveRequest request,User user)throws ServiceException{
        Course course = new Course();
        course.setId(request.getId());
        course.setUserId(user.getId());
        courseDao.remove(course);
    }

    /**
     * 添加文章
     * @param request
     * @param user
     * @throws ServiceException
     */
    public void addArticle(ArticleAddRequest request,User user)throws ServiceException{
        String filename = null;
        try {
            filename = QiniuUtils.getInstance().uploadPic(request.getHeadPhotoUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Article article = new Article();
        article.setUsername(user.getUsername());
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setHeadPhotoUrl(filename);
        article.setAuthor(request.getAuthor());
        article.setCategoryId(request.getCategoryId());
        article.setBoardNum(0);
        article.setReadNum(0L);
        article.setCreated(new Date());
        article.setStatus(1);
        articleDao.insert(article);
    }

    /**
     * 删除文章
     * @param request
     * @param user
     * @throws ServiceException
     */
    public void removeArticle(ArticleRemoveRequest request,User user)throws ServiceException{
        Article article = new Article();
        article.setId(request.getId());
        article.setUsername(user.getUsername());
        articleDao.remove(article);
    }

    /**
     * 获取文章列表
     * @param request
     * @return
     * @throws ServiceException
     */
    public ViewArticleList getArticleList(ArticleListGetRequest request)throws ServiceException{
        int startRow = (request.getPageNo() - 1)*request.getPageSize();
        Article article = new Article();
        article.setUsername(request.getUsername());
        article.setStartRow(startRow);
        article.setPageSize(request.getPageSize());
        List<Article> articles = articleDao.getList(article);
        int total = articleDao.getCount(article);
        ViewArticleList view = new ViewArticleList();
        view.setTotal(total);
        view.toResponse(articles);

        //设置分类名和从七牛获取图片
        for(ViewArticleList.ArticleListBean a : view.getArticleList()){
            a.setHeadPhotoUrl(QiniuUtils.getInstance().getDownloadLink(a.getHeadPhotoUrl()));
            Category category = new Category();
            category.setId(a.getId());
            category = categoryDao.get(category);
            if(category != null)
                a.setCategory(category.getName());
        }
        return view;
    }

    public static void main(String[] args) {
        Article articles =   new Article();
        ViewArticleList.ArticleListBean articleList = new ViewArticleList.ArticleListBean();
            convert(articles,articleList);


    }

    public static void convert(Object current,Object target) {
        try {
            Class now = current.getClass();
            Class newer = target.getClass();
            char[] chars = null;
            char[] nowname = now.getSimpleName().toCharArray();
            char[] newname = newer.getSimpleName().toCharArray();
            nowname[0] = Character.toLowerCase(nowname[0]);
            newname[0] = Character.toLowerCase(newname[0]);
            System.out.println(newer.getSimpleName()+" "+String.valueOf(nowname)+" = new "+newer.getSimpleName()+"();");
            System.out.println(now.getSimpleName()+" "+String.valueOf(nowname)+" = new "+now.getSimpleName()+"();");
            Field[] fields = now.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if("serialVersionUID".equals(fields[i].getName())){
                    continue;
                }
                chars = fields[i].getName().toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                StringBuilder sbuid = new StringBuilder().append(nowname)
                        .append(".set")
                        .append(String.valueOf(chars))
                        .append("(")
                        .append(newname)
                        .append(".get")
                        .append(String.valueOf(chars))
                        .append("());");
                System.out.println(sbuid.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }



}
