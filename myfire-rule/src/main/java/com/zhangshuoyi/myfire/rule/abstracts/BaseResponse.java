package com.zhangshuoyi.myfire.rule.abstracts;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用响应对象
 */
@Data
public abstract class BaseResponse implements Serializable {

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 创建人姓名
     */
    private String createUserName;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 更新人姓名
     */
    private String updateUserName;

}
