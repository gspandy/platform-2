package com.raycloud.module.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class TrainingInformationUpdateRequest extends Request {


    private static final long serialVersionUID = -2217604304656284954L;

    private String institution;
    private String desc;
    private String businessCode;
    private String addressCode;
    private String addressDetail;
    private String invitationCode;
    private String contactHotline;


    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
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

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }



    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getContactHotline() {
        return contactHotline;
    }

    public void setContactHotline(String contactHotline) {
        this.contactHotline = contactHotline;
    }
}
