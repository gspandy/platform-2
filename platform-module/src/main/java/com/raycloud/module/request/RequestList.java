package com.raycloud.module.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class RequestList extends Request {

    private Integer pageNo = 1;
    private Integer pageSize = 6;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
