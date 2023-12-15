package com.zhangshuoyi.myfire.rule.test;

import com.zhangshuoyi.myfire.rule.enums.YesOrNotEnum;
import org.junit.Test;

/**
 * 测试从枚举类型中取值
 */
public class EnumTest {

    @Test
    public void testGetEnumCodeAndDesc() {
        // 默认获取 desc 中的值
        System.out.println(YesOrNotEnum.YES);

        // 获取 code 中的值
        System.out.println(YesOrNotEnum.NO.getValue());
    }

}
