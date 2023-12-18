package com.zhangshuoyi.myfire.component.validator.util;

import java.util.regex.Pattern;

public class ValidatorUtil {

    // 验证邮箱格式
    private static final Pattern EMAIL_VERIFICATION = Pattern.compile("^(?!\\.)[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    // 验证手机号格式， 1 开头，后面跟 10 个数字
    private static final Pattern PHONE_VERIFICATION = Pattern.compile("^1\\d{10}$");

    /**
     * 验证账号格式
     *
     * 只能包含字母、数字和下划线。
     * 必须以字母开头。
     * 长度在 6 到 20 个字符之间。
     */
    private static final Pattern ACCOUNT_VERIFICATION = Pattern.compile("^(?=.*[A-Za-z])\\w{6,20}$");

    /**
     * 验证密码格式
     *
     * 必须包含至少一个大写字母、一个小写字母和一个数字。
     * 至少包含一个特殊字符（例如：!@#$%^&*）。
     * 长度在 6 到 20 个字符之间。
     */
    private static final Pattern PASSWORD_VERIFICATION = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])\\S{6,20}$");

    // 验证格式， 长度小于 6
    private static final Pattern LENGTH_TOO_SHORT = Pattern.compile("^.{0,5}$");

    // 验证格式， 长度大于 20
    private static final Pattern LENGTH_TOO_LONG = Pattern.compile("^.{21,}$");

    private ValidatorUtil() {

    }

    /**
     * 验证邮箱
     */
    public static boolean checkEmail(String email) {
        return check(EMAIL_VERIFICATION, email);
    }

    /**
     * 验证手机号
     */
    public static boolean checkPhone(String phone) {
        return check(PHONE_VERIFICATION, phone);
    }

    /**
     * 验证账号
     */
    public static boolean checkAccount(String account) {
        return check(ACCOUNT_VERIFICATION, account);
    }

    /**
     * 验证密码
     */
    public static boolean checkPassword(String password) {
        return check(PASSWORD_VERIFICATION, password);
    }

    /**
     * 验证字符串长度
     */
    public static String checkLength(String str) {
        if (check(LENGTH_TOO_SHORT, str)) {
            return "too_short";
        } else if (check(LENGTH_TOO_LONG, str)) {
            return "too_long";
        } else {
            return "true";
        }
    }

    /**
     * 验证
     */
    private static boolean check(Pattern pattern, String str) {
        return pattern.matcher(str).matches();
    }
}
