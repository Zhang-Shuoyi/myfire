package com.zhangshuoyi.myfire.rule.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * 枚举类型：是或否
 */
@Getter
public enum YesOrNotEnum implements IEnum<String> {
    YES("Y", "是"), NO("N", "否");

    @EnumValue
    private final String code;
    private final String desc;

    YesOrNotEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getValue() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
