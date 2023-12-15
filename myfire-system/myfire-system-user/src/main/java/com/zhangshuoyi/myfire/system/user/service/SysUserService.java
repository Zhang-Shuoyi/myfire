package com.zhangshuoyi.myfire.system.user.service;

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
     void add(SysUser request);

     /**
      * 删除
      */
     void del(SysUser request);

     /**
      * 编辑
      */
     void edit(SysUser request);

     /**
      * 详情
      */
     SysUser detail(SysUser request);

     /**
      * 分页
      */
     Page<SysUser> findPage(SysUser request);

     /**
      * 笔数
      */
     Long queryCount(SysUser request);

}
