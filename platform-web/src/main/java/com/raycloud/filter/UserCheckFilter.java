package com.raycloud.filter;

import com.raycloud.module.constant.UserConstant;
import com.raycloud.module.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/4/28.
 */
public class UserCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        //拦截的逻辑
        String uri = request.getRequestURI();
        if(uri.contains("/admin/")){
            /*Cookie[] cookies = request.getCookies();
            for(Cookie c : cookies){
                if(UserConstant.USER_INFO_KEY.equals(c.getName())){
                    //判断是否存在
                    chain.doFilter(req,resp);
                    return;
                }
            }*/
            User user = (User)request.getSession().getAttribute(UserConstant.USER_INFO_KEY);
            if(user != null && user.getId() != null && user.getId() == 1){
                chain.doFilter(req, resp);
            }else {
                throw new ServletException("权限不足");
            }
        }else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
