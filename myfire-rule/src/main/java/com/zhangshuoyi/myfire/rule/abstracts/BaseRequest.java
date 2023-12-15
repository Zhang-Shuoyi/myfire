package com.zhangshuoyi.myfire.rule.abstracts;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用请求对象
 */
@Data
public abstract class BaseRequest implements Serializable {

    /**
     * 备注
     */
    private String remark;

    /**
     * 页码
     */
    private Integer pageNo = 1;

    /**
     * 笔数
     */
    private Integer pageSize = 10;

}
