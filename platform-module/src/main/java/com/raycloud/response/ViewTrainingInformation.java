package com.raycloud.response;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class ViewTrainingInformation{

    private static final long serialVersionUID = 6288539375754817589L;

    private String insititution;
    private String desc;
    private String businessCode;
    private String addressDetail;
    private String addressCode;
    private String contactHotline;
    private String logoPicUrl;

    public String getInsititution() {
        return insititution;
    }

    public void setInsititution(String insititution) {
        this.insititution = insititution;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getContactHotline() {
        return contactHotline;
    }

    public void setContactHotline(String contactHotline) {
        this.contactHotline = contactHotline;
    }

    public String getLogoPicUrl() {
        return logoPicUrl;
    }

    public void setLogoPicUrl(String logoPicUrl) {
        this.logoPicUrl = logoPicUrl;
    }
}
