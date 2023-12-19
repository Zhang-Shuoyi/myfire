package com.zhangshuoyi.myfire.config.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置 Mapper 包扫描
 */
@Configuration
@MapperScan(basePackages = {"com.zhangshuoyi.**.mapper"})
public class MapperScanConfiguration {
}
