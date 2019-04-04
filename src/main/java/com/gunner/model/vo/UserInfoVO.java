package com.gunner.model.vo;

import com.gunner.model.pojo.UserInfo;

import java.util.List;

public class UserInfoVO extends UserInfo {
    private List<UserInfo> father;
    private List<UserInfo> mother;

    public List<UserInfo> getFather() {
        return father;
    }

    public void setFather(List<UserInfo> father) {
        this.father = father;
    }

    public List<UserInfo> getMother() {
        return mother;
    }

    public void setMother(List<UserInfo> mother) {
        this.mother = mother;
    }
}
