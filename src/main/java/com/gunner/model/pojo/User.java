package com.gunner.model.pojo;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author Sunmz
 * @since 2019-04-03 17:58:51
 */
public class User implements Serializable {
    private static final long serialVersionUID = -26835694082488678L;
    
    private Integer id;
    
    private String loginName;
    
    private String loginPassword;
    
    private String idcard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}