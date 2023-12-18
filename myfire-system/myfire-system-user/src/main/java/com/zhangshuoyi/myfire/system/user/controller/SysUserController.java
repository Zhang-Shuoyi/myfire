package com.zhangshuoyi.myfire.system.user.controller;

import com.zhangshuoyi.myfire.system.api.pojo.SysUserRequest;
import com.zhangshuoyi.myfire.system.api.pojo.dto.SysUserDTO;
import com.zhangshuoyi.myfire.system.user.domain.SysUser;
import com.zhangshuoyi.myfire.system.user.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ZhangShuoyi
 * @since 2023-12-15
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/{id}")
    public SysUserDTO detail(@PathVariable Long id) {

        SysUserDTO dto = new SysUserDTO();

        SysUserRequest request = new SysUserRequest();
        request.setUserId(id);

        SysUser sysUser = sysUserService.detail(request);
        BeanUtils.copyProperties(sysUser, dto);

        return dto;
    }

}
