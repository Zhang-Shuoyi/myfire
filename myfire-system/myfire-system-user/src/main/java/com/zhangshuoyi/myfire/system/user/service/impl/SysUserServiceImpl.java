package com.zhangshuoyi.myfire.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangshuoyi.myfire.component.validator.util.ValidatorUtil;
import com.zhangshuoyi.myfire.rule.constant.SysUserConstants;
import com.zhangshuoyi.myfire.system.api.exception.SystemException;
import com.zhangshuoyi.myfire.system.api.pojo.SysUserRequest;
import com.zhangshuoyi.myfire.system.user.domain.SysUser;
import com.zhangshuoyi.myfire.system.user.mapper.SysUserMapper;
import com.zhangshuoyi.myfire.system.user.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
    public void add(SysUserRequest request) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(request, sysUser);

        check(sysUser);

        setDefaultCreateUserAndUpdateUser(sysUser);

        this.save(sysUser);
    }

    @Override
    public void del(SysUserRequest request) {
        this.removeById(queryById(request));
    }

    @Override
    public void edit(SysUserRequest request) {
        SysUser sysUser = queryById(request);
        BeanUtils.copyProperties(request, sysUser);
        this.updateById(sysUser);
    }

    @Override
    public SysUser detail(SysUserRequest request) {
        if (notEmpty(request.getUserId())) {
            return queryById(request);
        } else {
            return this.getOne(createWrapper(request));
        }
    }

    @Override
    public Page<SysUser> findPage(SysUserRequest request) {
        return this.page(new Page<>(request.getPageNo(), request.getPageSize()), createWrapper(request));
    }

    @Override
    public Long queryCount(SysUserRequest request) {
        return this.count(createWrapper(request));
    }


    /**
     * 查询用户是否存在
     */
    private SysUser queryById(SysUserRequest request) {
        SysUser sysUser = getById(request.getUserId());
        if (isEmpty(sysUser)) {
            throw new SystemException("用户不存在");
        }
        return sysUser;
    }

    /**
     * 创建 wrapper
     */
    private LambdaQueryWrapper<SysUser> createWrapper(SysUserRequest request) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();

        if (isEmpty(request)) {
            return wrapper;
        }

        // 查询条件
        Long userId = request.getUserId();
        String email = request.getEmail();
        String phone = request.getPhone();
        String account = request.getAccount();
        String password = request.getPassword();

        // 拼接 SQL
        wrapper.eq(notEmpty(userId), SysUser::getUserId, userId);
        wrapper.eq(notEmpty(email), SysUser::getEmail, email);
        wrapper.eq(notEmpty(phone), SysUser::getPhone, phone);
        wrapper.eq(notEmpty(account), SysUser::getAccount, account);
        wrapper.eq(notEmpty(password), SysUser::getPassword, password);

        return wrapper;
    }

    /**
     * 设置 创建人 和 更新人 默认为 admin
     */
    private void setDefaultCreateUserAndUpdateUser(SysUser sysUser) {
        if (isEmpty(sysUser.getCreateUser())) {
            sysUser.setCreateUser(SysUserConstants.SYS_USER_ADMIN_ID);
        }

        if (isEmpty(sysUser.getUpdateUser())) {
            sysUser.setUpdateUser(SysUserConstants.SYS_USER_ADMIN_ID);
        }
    }

    // -------------------- 表单验证 begin --------------------

    /**
     * 验证格式
     */
    private void check(SysUser sysUser) {

    }

    /**
     * 判断为空
     */
    private boolean isEmpty(Object object) {
        return ObjectUtils.isEmpty(object);
    }

    /**
     * 判断非空
     */
    private boolean notEmpty(Object object) {
        return !ObjectUtils.isEmpty(object);
    }

    /**
     * 验证姓名 不为空
     * @param realName 姓名
     */
    private void checkRealName(String realName) {
        // 非空验证
        if (isEmpty(realName)) {
            throw new SystemException("姓名不能为空");
        }
    }

    /**
     * 验证邮箱格式
     * @param email 邮箱
     */
    private void checkEmail(String email) {
        // 非空验证
        if (isEmpty(email)) {
            throw new SystemException("邮箱不能为空");
        }

        // 格式验证
        if (!ValidatorUtil.checkEmail(email)) {
            throw new SystemException("邮箱格式不匹配");
        }

        // 验证是否已存在
        SysUserRequest request = new SysUserRequest();
        request.setEmail(email);
        if (queryCount(request) != 0) {
            throw new SystemException("邮箱已存在");
        }
    }

    /**
     * 验证手机号格式
     * @param phone 手机号
     */
    private void checkPhone(String phone) {
        // 非空验证
        if (isEmpty(phone)) {
            throw new SystemException("手机号不能为空");
        }

        // 格式验证
        if (!ValidatorUtil.checkPhone(phone)) {
            throw new SystemException("手机号格式不匹配");
        }

        // 验证是否存在
        SysUserRequest request = new SysUserRequest();
        request.setPhone(phone);
        if (queryCount(request) != 0) {
            throw new SystemException("手机号已存在");
        }
    }

    /**
     * 验证账号格式
     * @param account 账号
     */
    private void checkAccount(String account) {
        // 非空验证
        if (isEmpty(account)) {
            throw new SystemException("账号不能为空");
        }

        // 格式验证
        if (!ValidatorUtil.checkAccount(account)) {
            throw new SystemException("账号格式不匹配");
        }

        // 验证是否存在
        SysUserRequest request = new SysUserRequest();
        request.setAccount(account);
        if (queryCount(request) != 0) {
            throw new SystemException("账号已存在");
        }
    }

    /**
     * 验证密码格式
     * @param password 密码
     */
    private void checkPassword(String password) {
        // 非空验证
        if (isEmpty(password)) {
            throw new SystemException("密码不能为空");
        }

        // 格式验证
        checkLength(password);
        if (!ValidatorUtil.checkPassword(password)) {
            throw new SystemException("密码格式不匹配");
        }
    }

    /**
     * 验证长度
     * @param str 需要验证的字符串
     */
    private void checkLength(String str) {
        if (ValidatorUtil.checkLength(str).equals("too_short")) {
            throw new SystemException("长度过短！");
        }

        if (ValidatorUtil.checkLength(str).equals("too_long")) {
            throw new SystemException("长度过长！");
        }
    }
}
