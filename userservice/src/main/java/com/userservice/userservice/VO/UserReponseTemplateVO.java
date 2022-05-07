package com.userservice.userservice.VO;

import com.userservice.userservice.entity.User;


public class UserReponseTemplateVO {
    private User user;
    public UserReponseTemplateVO() {
    }
    private Department department;
    public UserReponseTemplateVO(User user, Department department) {
        this.user = user;
        this.department = department;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    
}
