package com.zhangshuoyi.myfire.system.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangshuoyi.myfire.system.user.domain.SysUser;
import com.zhangshuoyi.myfire.system.user.mapper.SysUserMapper;
import com.zhangshuoyi.myfire.system.user.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ZhangShuoyi
 * @since 2023-12-15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public void add(SysUser request) {

    }

    @Override
    public void del(SysUser request) {

    }

    @Override
    public void edit(SysUser request) {

    }

    @Override
    public SysUser detail(SysUser request) {
        return null;
    }

    @Override
    public Page<SysUser> findPage(SysUser request) {
        return null;
    }

    @Override
    public Long queryCount(SysUser request) {
        return null;
    }
}