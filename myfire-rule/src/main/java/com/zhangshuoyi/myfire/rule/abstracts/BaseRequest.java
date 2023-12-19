package com.zhangshuoyi.myfire.rule.abstracts;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(name = "remark", description = "备注")
    private String remark;

    /**
     * 页码
     */
    @Schema(name = "pageNo", description = "页码")
    private Integer pageNo = 1;

    /**
     * 笔数
     */
    @Schema(name = "pageSize", description = "笔数")
    private Integer pageSize = 10;

}
