package com.raycloud.response;

import com.raycloud.pojo.User;
import com.raycloud.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/8/24.
 */
public class ViewUserList extends ListResponse {

    public void toResponse(List<User> userList){
        if(userList == null || userList.size() == 0){
            return;
        }
        InstitutionListBean institutionListBean = null;
        institutionList = new ArrayList<InstitutionListBean>();
        for(User u : userList){
            institutionListBean = new InstitutionListBean();
            institutionListBean.setId(u.getId());
            institutionListBean.setUsername(u.getUsername());
            institutionListBean.setPreNo(u.getPreNo());
            institutionListBean.setInstitution(u.getInstitution());
            institutionListBean.setOwner(u.getOwner());
            institutionListBean.setPhone(u.getPhone());
            institutionListBean.setCreated(DateUtil.getDateTime(u.getCreated(),
                    DateUtil.DATE_FORMAT));
            institutionListBean.setStatus(u.getStatus() == 0 ? "停用" : "正常");
            institutionList.add(institutionListBean);
        }




    }

    /**
     * id : 1
     * username : qq123123
     * preNo : 170
     * institution : 峨眉派
     * owner : 林俊杰
     * phone : 15675205364
     */

    private List<InstitutionListBean> institutionList;

    public List<InstitutionListBean> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<InstitutionListBean> institutionList) {
        this.institutionList = institutionList;
    }

    public static class InstitutionListBean {
        private Long id;
        private String username;
        private String preNo;
        private String institution;
        private String owner;
        private String phone;
        private String created;
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPreNo() {
            return preNo;
        }

        public void setPreNo(String preNo) {
            this.preNo = preNo;
        }

        public String getInstitution() {
            return institution;
        }

        public void setInstitution(String institution) {
            this.institution = institution;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
