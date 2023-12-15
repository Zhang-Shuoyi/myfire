package com.zhangshuoyi.myfire.system.user.service;

import com.zhangshuoyi.myfire.system.api.pojo.SysUserRequest;
import com.zhangshuoyi.myfire.system.user.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ZhangShuoyi
 * @since 2023-12-15
 */
public interface SysUserService extends IService<SysUser> {

     /**
      * 新增
      */
     void add(SysUserRequest request);

     /**
      * 删除
      */
     void del(SysUserRequest request);

     /**
      * 编辑
      */
     void edit(SysUserRequest request);

     /**
      * 详情
      */
     SysUser detail(SysUserRequest request);

     /**
      * 分页
      */
     Page<SysUser> findPage(SysUserRequest request);

     /**
      * 笔数
      */
     Long queryCount(SysUserRequest request);

}
