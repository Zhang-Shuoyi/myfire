package com.zhangshuoyi.myfire.component.db.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zhangshuoyi.myfire.component.db.constants.DBFieldConstants;
import com.zhangshuoyi.myfire.rule.enums.YesOrNotEnum;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 字段自动填充
 * <p>
 * MyBatis-Plus 执行新增或更新时自动操作
 * </p>
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建时间
        this.strictInsertFill(metaObject, DBFieldConstants.CREATE_TIME, Date.class, new Date());

        // 更新时间
        this.strictInsertFill(metaObject, DBFieldConstants.UPDATE_TIME, Date.class, new Date());

        // 删除标记
        this.strictInsertFill(metaObject, DBFieldConstants.DEL_FLAG, String.class, YesOrNotEnum.NO.getValue());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时间
        metaObject.setValue(DBFieldConstants.UPDATE_TIME, new Date());
    }
}
