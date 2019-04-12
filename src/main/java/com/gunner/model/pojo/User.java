package com.gunner.model.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author Sunmz
 * @since 2019-04-08 09:52:34
 */
public class User implements Serializable {
    private static final long serialVersionUID = 689830371307007943L;
    
    private Integer id;
    
    private String uuid;
    //登录名
    private String loginName;
    //登录密码
    private String loginPassword;
    
    private String purview;
    
    private Date modifyTime;
    
    private String modifyUuid;
    
    private String modifyIp;
    
    private Date createTime;
    
    private String createUuid;
    
    private String createIp;
    //0-禁止登陆，1-正常，2-需修改密码
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPurview() {
        return purview;
    }

    public void setPurview(String purview) {
        this.purview = purview;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUuid() {
        return modifyUuid;
    }

    public void setModifyUuid(String modifyUuid) {
        this.modifyUuid = modifyUuid;
    }

    public String getModifyIp() {
        return modifyIp;
    }

    public void setModifyIp(String modifyIp) {
        this.modifyIp = modifyIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUuid() {
        return createUuid;
    }

    public void setCreateUuid(String createUuid) {
        this.createUuid = createUuid;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}