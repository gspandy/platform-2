package com.raycloud.web;

import com.raycloud.request.CategoryAddRequest;
import com.raycloud.request.CategoryDeleteRequest;
import com.raycloud.request.VideoDeleteRequest;
import com.raycloud.response.Response;
import com.raycloud.service.impl.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/7.
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    private PublicService publicService;

}
