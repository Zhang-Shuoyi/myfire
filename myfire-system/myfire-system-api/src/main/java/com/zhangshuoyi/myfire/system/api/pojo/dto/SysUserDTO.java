package com.zhangshuoyi.myfire.system.api.pojo.dto;

import com.zhangshuoyi.myfire.rule.abstracts.BaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

/**
 * 数据传输对象
 */
@Data
@ToString
@ApiModel(description = "用户数据传输对象")
@EqualsAndHashCode(callSuper = true)
public class SysUserDTO extends BaseResponse {

    /**
     * 主键ID
     */
    @Schema(name = "userId", description = "主键 ID")
    private Long userId;

    /**
     * 姓名
     */
    @Schema(name = "realName", description = "姓名")
    private String realName;

    /**
     * 昵称
     */
    @Schema(name = "nickName", description = "昵称")
    private String nickName;

    /**
     * 类型
     */
    @Schema(name = "userType", description = "类型")
    private String userType;

    /**
     * 邮箱
     */
    @Schema(name = "email", description = "邮箱")
    private String email;

    /**
     * 手机
     */
    @Schema(name = "phone", description = "手机")
    private String phone;

    /**
     * 电话
     */
    @Schema(name = "tel", description = "电话")
    private String tel;

    /**
     * 性别：M-男，F-女
     */
    @Schema(name = "sex", description = "性别：M-男，F-女")
    private String sex;

    /**
     * 账号
     */
    @Schema(name = "account", description = "账号")
    private String account;

    /**
     * 头像
     */
    @Schema(name = "avatar", description = "头像")
    private String avatar;

    /**
     * 生日
     */
    @Schema(name = "birthday", description = "生日")
    private LocalDate birthday;

    /**
     * 是否超级管理员：Y-是，N-否
     */
    @Schema(name = "flagSuperAdmin", description = "是否超级管理员：Y-是，N-否")
    private String flagSuperAdmin;

    /**
     * 状态：1-正常，2-冻结
     */
    @Schema(name = "status", description = "状态：1-正常，2-冻结")
    private Byte status;

}
