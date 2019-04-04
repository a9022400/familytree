package com.gunner.model.dto;

import com.gunner.condition.BaseCondition;

import java.sql.Date;

public class UserInfoDTO extends BaseCondition {

    private Integer id;

    private String name;

    private String oldName;

    private String sex;

    private String idcard;

    private Date  birth;

    private String fatherIdcard;

    private String motherIdcard;

    private String partnerIdcard;
    //头像路径
    private String img;

    private String text;

    private String temp1;

    private String temp2;

    private String temp3;

    private String temp4;

    private String pageCount;

    private String allCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getFatherIdcard() {
        return fatherIdcard;
    }

    public void setFatherIdcard(String fatherIdcard) {
        this.fatherIdcard = fatherIdcard;
    }

    public String getMotherIdcard() {
        return motherIdcard;
    }

    public void setMotherIdcard(String motherIdcard) {
        this.motherIdcard = motherIdcard;
    }

    public String getPartnerIdcard() {
        return partnerIdcard;
    }

    public void setPartnerIdcard(String partnerIdcard) {
        this.partnerIdcard = partnerIdcard;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }

    public String getTemp4() {
        return temp4;
    }

    public void setTemp4(String temp4) {
        this.temp4 = temp4;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getAllCount() {
        return allCount;
    }

    public void setAllCount(String allCount) {
        this.allCount = allCount;
    }
}
