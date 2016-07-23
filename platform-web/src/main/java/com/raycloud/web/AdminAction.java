package com.raycloud.web;

import com.raycloud.service.impl.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/7.
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    private PublicService publicService;

}
