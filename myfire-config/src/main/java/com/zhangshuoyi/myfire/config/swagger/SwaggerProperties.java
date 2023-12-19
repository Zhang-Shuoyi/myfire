package com.zhangshuoyi.myfire.config.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.swagger")
public class SwaggerProperties {

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * API 分组
     */
    private String groupName;

    /**
     * 对某个包的接口进行监听
     */
    private String basePackage;

    /**
     * 文档版本
     */
    private String version;

    /**
     * 文档标题
     */
    private String title;

    /**
     * 文档描述
     */
    private String description;

    /**
     * 联系人姓名
     */
    private String contactName;


    /**
     * 联系人邮箱
     */
    private String contactEmail;

    /**
     * 联系人网站
     */
    private String contactUrl;
}
