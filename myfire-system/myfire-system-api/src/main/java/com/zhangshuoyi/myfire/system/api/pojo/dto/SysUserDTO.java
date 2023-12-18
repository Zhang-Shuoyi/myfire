package com.zhangshuoyi.myfire.system.api.pojo.dto;

import java.time.LocalDate;

/**
 * 数据传输对象
 */
public class SysUserDTO {

    /**
     * 主键ID
     */
    private Long userId;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 类型
     */
    private String userType;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String phone;

    /**
     * 电话
     */
    private String tel;

    /**
     * 性别：M-男，F-女
     */
    private String sex;

    /**
     * 账号
     */
    private String account;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 是否超级管理员：Y-是，N-否
     */
    private String flagSuperAdmin;

    /**
     * 状态：1-正常，2-冻结
     */
    private Byte status;

}
