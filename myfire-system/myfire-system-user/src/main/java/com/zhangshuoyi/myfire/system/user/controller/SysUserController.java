package com.zhangshuoyi.myfire.system.user.controller;

import com.zhangshuoyi.myfire.rule.pojo.ResponseResult;
import com.zhangshuoyi.myfire.system.api.pojo.SysUserRequest;
import com.zhangshuoyi.myfire.system.api.pojo.dto.SysUserDTO;
import com.zhangshuoyi.myfire.system.user.domain.SysUser;
import com.zhangshuoyi.myfire.system.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;
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
@Api(tags = "用户模块")
@RestController
@RequestMapping("/api/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/{id}")
    @Operation(summary = "查询用户详情", description = "根据 ID 返回用户详情")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "404", description = "用户不存在", content
                    = @Content)
    })
    public ResponseResult<SysUserDTO> detail(@PathVariable Long id) {
        SysUserRequest request = new SysUserRequest();
        request.setUserId(id);

        SysUser sysUser = sysUserService.detail(request);

        SysUserDTO dto = new SysUserDTO();
        BeanUtils.copyProperties(sysUser, dto);

        if (ObjectUtils.isEmpty(dto)) {
            return ResponseResult.fail(dto);
        } else {
            return ResponseResult.success(dto);
        }
    }

}
