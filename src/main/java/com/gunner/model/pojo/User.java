package com.gunner.model.pojo;

import java.sql.Date ;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author Sunmz
 * @since 2019-04-01 11:25:22
 */
public class User implements Serializable {
    private static final long serialVersionUID = 575483227912038355L;
    
    private Integer id;
    
    private String name;
    
    private String oldname;
    
    private String sex;
    
    private String idcard;
    
    private Date  birth;
    
    private Integer fatherid;
    
    private Integer motherid;
    
    private Integer partnerid;
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

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
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

    public Date  getBirth() {
        return birth;
    }

    public void setBirth(Date  birth) {
        this.birth = birth;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    public Integer getMotherid() {
        return motherid;
    }

    public void setMotherid(Integer motherid) {
        this.motherid = motherid;
    }

    public Integer getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(Integer partnerid) {
        this.partnerid = partnerid;
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
    public String getPageCount() {return pageCount;}
    public void setPageCount(String pageCount) {this.pageCount = pageCount;}
    public String getAllCount() {return allCount;}
    public void setAllCount(String allCount) {this.allCount = allCount;}
}