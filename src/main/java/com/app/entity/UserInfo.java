package com.app.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName  ${NAME}
 * @Author shaobin.wang
 * @Date  2019/06/19 10:11
 * @Version 1.0
 * @Description:  
 **/
@Data
public class UserInfo implements Serializable {
    /**
    * 唯一标识
    */
    private Long id;

    /**
    * 用户名称
    */
    private String userName;

    /**
    * 用户手机号
    */
    private String phone;

    /**
    * 用户微信号ID
    */
    private String openid;

    /**
    * 创建时间
    */
    private Date createtime;

    /**
    * 更新时间
    */
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}